package com.pdg.WhatsApp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.activities.Chat;
import com.pdg.WhatsApp.adapters.ChatRecyclerAdapter;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class ChatFragment extends Fragment {
    Realm realm;
    RealmResults<Chats> realmChat;
    RealmResults<Chats> realmChat2;
    RealmList<Chats> chats;
    RecyclerView recyclerView;
    ChatRecyclerAdapter chatRecyclerAdapter;
    private DataListener callback;
    String nombre;


    public static RealmList<Chats> getChatByName(String nombre, RealmResults<Chats> realmChat2) {
        RealmList<Chats> result = new RealmList<>();
        for (Chats chat : realmChat2) {
            for(String s : chat.getNombreUsers()) {
                if (s.equals(nombre)){
                    result.add(chat);
                }
            }
        }
        return result.isEmpty() ? new RealmList<Chats>() : result;
    }

    public interface DataListener {
        public void sendData(Integer Data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            callback = (DataListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + "should implement DataListener");
        }
    }
    public ChatFragment() {}
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        realm = Realm.getDefaultInstance();

        //Lista de todos los chats
        realmChat2 = realm.where(Chats.class).findAll();


        chats = getChatByName(nombre,realmChat2);



        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerChatId);

        chatRecyclerAdapter = new ChatRecyclerAdapter(chats, getActivity().getBaseContext(), new ChatRecyclerAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(RealmList<Mensaje> mensajes, int position) {
                Integer id = chats.get(position).getId();
                callback.sendData(id);

                Intent intent = new Intent(getActivity(), Chat.class);
                intent.putExtra("name", nombre);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(chatRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        return view;
    }
}