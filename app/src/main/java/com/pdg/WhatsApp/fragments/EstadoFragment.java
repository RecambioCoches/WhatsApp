package com.pdg.WhatsApp.fragments;

import static io.realm.Realm.getApplicationContext;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.ChatRecyclerAdapter;
import com.pdg.WhatsApp.adapters.Estado2RecyclerAdapter;
import com.pdg.WhatsApp.adapters.EstadoRecyclerAdapter;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Estado;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

public class EstadoFragment extends Fragment {

    Realm realm;
    RealmResults<Estado> realmEstado;
    RecyclerView recyclerView;

    public EstadoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        realm = Realm.getDefaultInstance();
        realmEstado = realm.where(Estado.class).findAll();

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerChatId);

        Estado2RecyclerAdapter estado2RecyclerAdapter = new Estado2RecyclerAdapter(realmEstado,getActivity().getBaseContext());

        recyclerView.setAdapter(estado2RecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        return view;
    }


}