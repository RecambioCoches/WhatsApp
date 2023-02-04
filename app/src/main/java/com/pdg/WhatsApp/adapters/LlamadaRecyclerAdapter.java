package com.pdg.WhatsApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Llamada;

import io.realm.RealmResults;

public class LlamadaRecyclerAdapter extends RecyclerView.Adapter <LlamadaRecyclerAdapter.RecyclerDataHolder> {

    RealmResults<Llamada> realmChat;


    public LlamadaRecyclerAdapter(RealmResults<Llamada> realmChat, Context baseContext) {
        this.realmChat = realmChat;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.llamada_item,null,false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.assignDataChat(realmChat.get(position));
    }

    @Override
    public int getItemCount() {
        return realmChat.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView fecha;
        TextView estado;
        ImageView foto;

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.txtNombreLlamada);
            fecha = (TextView) itemView.findViewById(R.id.txtHoraLlamada);
            estado = (TextView) itemView.findViewById(R.id.txtEstadoLlamada);
            foto = (ImageView) itemView.findViewById(R.id.imgLlamada);
        }


        public void assignDataChat(Llamada llamada) {

            this.nombre.setText(llamada.getNombreUsuario());
            this.fecha.setText(llamada.getFecha());
            this.estado.setText(llamada.getEstadoLlamada());
            this.foto.setImageResource(llamada.getFoto());
        }
    }



}

