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

    Realm realm;
    RealmList<Chats> realmChat;
    private View.OnClickListener listener;
    private OnItemClickListener itemListener;


    public ChatRecyclerAdapter(RealmList<Chats> realmChat, Context baseContext, OnItemClickListener onItemClickListener) {
        this.realmChat = realmChat;
        this.itemListener = (OnItemClickListener) onItemClickListener;
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
        View itemView = holder.itemView;
        Chats chat = realmChat.get(position);
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
        ImageView imagenChat;
        TextView nombreChat;
        TextView mensajeChat;
        TextView horaChat;
        TextView cantidadMensajes;

        TextView nombredelChat;
        ImageView imagendelChat;
        CardView cardView;

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);
            imagenChat = (ImageView) itemView.findViewById(R.id.imageViewChat);
            nombreChat = (TextView) itemView.findViewById(R.id.textViewNombreChat);
            mensajeChat = (TextView) itemView.findViewById(R.id.textViewMensajeChat);
            horaChat = (TextView) itemView.findViewById(R.id.textViewHoraChat);
            cantidadMensajes = (TextView) itemView.findViewById(R.id.textViewCantidadMensajes);
            cardView = itemView.findViewById(R.id.cardviewCantidad);

            //Mensaje
            imagendelChat  = (ImageView) itemView.findViewById(R.id.imageView);
            nombredelChat = (TextView) itemView.findViewById(R.id.textViewNombreCabecera);



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
                this.cantidadMensajes.setText(String.valueOf(mensajesNoLeidos));

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


