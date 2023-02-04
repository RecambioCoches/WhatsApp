package com.pdg.WhatsApp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.LlamadaRecyclerAdapter;
import com.pdg.WhatsApp.model.Llamada;

import io.realm.Realm;
import io.realm.RealmResults;

public class LlamadaFragment extends Fragment {

    Realm realm;
    RealmResults<Llamada> realmLlamada;
    RecyclerView recyclerView;

    public LlamadaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        realm = Realm.getDefaultInstance();
        realmLlamada = realm.where(Llamada.class).findAll();

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerChatId);

        LlamadaRecyclerAdapter llamadaRecyclerAdapter = new LlamadaRecyclerAdapter(realmLlamada,getActivity().getBaseContext());

        recyclerView.setAdapter(llamadaRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(),1));
        return view;
    }
}