package com.pdg.WhatsApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;

import io.realm.Realm;
import io.realm.RealmList;

public class ChatRecyclerAdapter extends RecyclerView.Adapter <ChatRecyclerAdapter.RecyclerDataHolder> implements View.OnClickListener {

    RealmList<Chats> realmChat;
    private OnItemClickListener itemListener;


    public ChatRecyclerAdapter(RealmList<Chats> realmChat, OnItemClickListener onItemClickListener) {
        this.realmChat = realmChat;
        this.itemListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list,null,false);
        view.setOnClickListener(this);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.assignDataChat(realmChat.get(position),itemListener);
    }

    @Override
    public int getItemCount() {
        return realmChat.size();
    }

    @Override
    public void onClick(View view) {

    }
    public interface OnItemClickListener{
        void onItemClick(RealmList<Mensaje> mensajes, int position);
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder{
        ImageView imagenChat,imagendelChat;
        TextView nombreChat,mensajeChat,horaChat,cantidadMensajes,nombredelChat;
        CardView cardView;

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);
            imagenChat = itemView.findViewById(R.id.imageViewChat);
            nombreChat = itemView.findViewById(R.id.textViewNombreChat);
            mensajeChat = itemView.findViewById(R.id.textViewMensajeChat);
            horaChat = itemView.findViewById(R.id.textViewHoraChat);
            cantidadMensajes = itemView.findViewById(R.id.textViewCantidadMensajes);
            cardView = itemView.findViewById(R.id.cardviewCantidad);
            imagendelChat  = itemView.findViewById(R.id.imageView);
            nombredelChat = itemView.findViewById(R.id.textViewNombreCabecera);
        }


        public void assignDataChat(Chats chats, final OnItemClickListener onItemClickListener) {
            this.nombreChat.setText(chats.getNombreChat());
            if (chats.getMensajes().size() == 0){
                this.mensajeChat.setText("");
                this.horaChat.setText("");
                this.cantidadMensajes.setText("");
                this.cardView.setVisibility(View.GONE);
            }else{
                Mensaje ultimoMensaje = chats.getMensajes().get(chats.getMensajes().size() - 1);
                this.mensajeChat.setText(ultimoMensaje.getMensaje());
                this.horaChat.setText(ultimoMensaje.getTiempo().toString());
                int mensajesNoLeidos = 0;
                for (Mensaje mensaje : chats.getMensajes()) {
                    if (mensaje.getId() > chats.getUltimoMensajeLeido()) {
                        mensajesNoLeidos++;
                    }
                }
                if (mensajesNoLeidos == 0){
                    this.cantidadMensajes.setText("");
                }else {
                    this.cantidadMensajes.setText(String.valueOf(mensajesNoLeidos));
                }



            }
            if (cantidadMensajes.getText() == "") {
                cardView.setVisibility(View.GONE);
            } else {
                cardView.setVisibility(View.VISIBLE);
            }

            this.nombreChat.setText(chats.getNombreChat());
            this.imagenChat.setImageResource(chats.getImagen());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(chats.getMensajes(),getAdapterPosition());
                }
            });
        }
    }



}


