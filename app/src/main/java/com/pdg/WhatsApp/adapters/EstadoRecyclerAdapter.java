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
import com.pdg.WhatsApp.model.Estado;

import io.realm.RealmResults;

public class EstadoRecyclerAdapter extends RecyclerView.Adapter <EstadoRecyclerAdapter.RecyclerDataHolder> {

    RealmResults<Estado> realmChat;


    public EstadoRecyclerAdapter(RealmResults<Estado> realmChat, Context baseContext) {
        this.realmChat = realmChat;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.estado_item,null,false);
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
        ImageView imagenChat;
        TextView nombreChat;
        TextView horaChat;

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);
            imagenChat = (ImageView) itemView.findViewById(R.id.imgEstado);
            nombreChat = (TextView) itemView.findViewById(R.id.txtNombreEstado);
            horaChat = (TextView) itemView.findViewById(R.id.txtTiempoEstado);
        }


        public void assignDataChat(Estado chats) {

            this.nombreChat.setText(chats.getNombreUsuario());
            this.imagenChat.setImageResource(chats.getFoto());
            this.horaChat.setText(chats.getTiempo());
        }
    }



}

