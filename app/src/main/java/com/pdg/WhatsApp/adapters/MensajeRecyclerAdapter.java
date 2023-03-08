package com.pdg.WhatsApp.adapters;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MensajeRecyclerAdapter extends RecyclerView.Adapter <MensajeRecyclerAdapter.RecyclerDataHolder> {

    RealmList<Mensaje> realmMensaje;
    private String name;



    public MensajeRecyclerAdapter(RealmList<Mensaje> realmMensaje, String name) {
        this.realmMensaje = realmMensaje;
        this.name = name;

    }

    @NonNull
    @Override
    public MensajeRecyclerAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mensaje_list,null,false);
        return new MensajeRecyclerAdapter.RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeRecyclerAdapter.RecyclerDataHolder holder, int position) {
        View itemView = holder.itemView;

        Mensaje mensaje = realmMensaje.get(position);
        holder.assignDataChat(itemView, mensaje, name);
    }

    @Override
    public int getItemCount() {
        return realmMensaje.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder{

        TextView mensaje;
        String nombreUser;

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);

            mensaje = itemView.findViewById(R.id.textViewMensajeList);
        }


        public void assignDataChat(View itemView, Mensaje mensaje, String name) {
            TextView mensajeTextView = itemView.findViewById(R.id.textViewMensajeList);
            LinearLayout linearCardView = itemView.findViewById(R.id.mensaje_text_view);
            mensajeTextView.setText(mensaje.getMensaje());
            nombreUser = mensaje.getNombreUsuario();

            if (nombreUser.equals(name)) {
                linearCardView.setGravity(Gravity.END);

            } else {
                linearCardView.setGravity(Gravity.START);
            }
        }
    }
}
