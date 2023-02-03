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

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

public class EstadoFragment extends Fragment {

    Realm realm;
    RealmResults<Estado> realmEstado;
    RecyclerView recyclerView;
    EstadoRecyclerAdapter estadoRecyclerAdapter;

    public EstadoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        realm = Realm.getDefaultInstance();
        realmEstado = realm.where(Estado.class).findAll();
        View view = inflater.inflate(R.layout.fragment_estado, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewEstados);
        recyclerView.setAdapter(estadoRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity().getApplicationContext(),1));
        return view;
    }
}