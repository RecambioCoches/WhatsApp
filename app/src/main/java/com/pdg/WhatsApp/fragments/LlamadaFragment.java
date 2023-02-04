package com.pdg.WhatsApp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.Estado2RecyclerAdapter;
import com.pdg.WhatsApp.adapters.EstadoRecyclerAdapter;
import com.pdg.WhatsApp.adapters.Llamada2RecyclerAdapter;
import com.pdg.WhatsApp.adapters.LlamadaRecyclerAdapter;
import com.pdg.WhatsApp.model.Estado;
import com.pdg.WhatsApp.model.Llamada;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

public class LlamadaFragment extends Fragment {

    Realm realm;
    RealmResults<Llamada> realmLlamada;
    RecyclerView recyclerView;
    LlamadaRecyclerAdapter llamadaRecyclerAdapter;

    public LlamadaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        realm = Realm.getDefaultInstance();
        realmLlamada = realm.where(Llamada.class).findAll();

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerChatId);

        Llamada2RecyclerAdapter llamada2RecyclerAdapter = new Llamada2RecyclerAdapter(realmLlamada,getActivity().getBaseContext());

        recyclerView.setAdapter(llamada2RecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        return view;
    }
}