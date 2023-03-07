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
import android.widget.ImageView;
import android.widget.TextView;


import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.activities.Chat;
import com.pdg.WhatsApp.adapters.ChatRecyclerAdapter;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;
import com.pdg.WhatsApp.utils.Utils;

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
            RealmList<String> chatUsers = chat.getNombreUsers();
            if (chatUsers.size() == 2) {
                String user1 = chatUsers.get(0);
                String user2 = chatUsers.get(1);
                String chatName;
                if (user1.equals(nombre)) {
                    chatName = user2;
                } else if (user2.equals(nombre)) {
                    chatName = user1;
                } else {
                    continue;
                }
                Chats renamedChat = new Chats(chatName, chat.getMensajes(), chat.getImagen(), chatUsers, false,chat.getUltimoMensajeLeido());
                renamedChat.setId(chat.getId());
                result.add(renamedChat);
            } else if (chatUsers.contains(nombre)) { // Group chat
                Chats renamedChat = new Chats(chat.getNombreChat(), chat.getMensajes(), chat.getImagen(), chatUsers, true,chat.getUltimoMensajeLeido());
                renamedChat.setId(chat.getId());
                result.add(renamedChat);
            }
        }
        return result;
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
                Integer imagen = chats.get(position).getImagen();
                String nombreCabecera = chats.get(position).getNombreChat();
                callback.sendData(id);


                Intent intent = new Intent(getActivity(), Chat.class);
                intent.putExtra("name", nombre);
                intent.putExtra("id", id);
                intent.putExtra("nameCabecera", nombreCabecera);
                intent.putExtra("imagen", imagen);

                Chats chat = realm.where(Chats.class).equalTo("id", id).findFirst();
                int ultimoMensajeId = chat.getMensajes().last().getId();
                realm.beginTransaction();
                chat.setUltimoMensajeLeido(ultimoMensajeId);
                realm.copyToRealmOrUpdate(chat);
                realm.commitTransaction();



                startActivity(intent);


            }
        });

        recyclerView.setAdapter(chatRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        return view;
    }
}