package com.pdg.WhatsApp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.EstadoRecyclerAdapter;
import com.pdg.WhatsApp.model.Estado;

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

        recyclerView = view.findViewById(R.id.recyclerChatId);

        EstadoRecyclerAdapter estadoRecyclerAdapter = new EstadoRecyclerAdapter(realmEstado);

        recyclerView.setAdapter(estadoRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        return view;
    }


}