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
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;

import org.w3c.dom.Text;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChatRecyclerAdapter extends RecyclerView.Adapter <ChatRecyclerAdapter.RecyclerDataHolder> implements View.OnClickListener {

    Realm realm;
    RealmResults<Chats> realmChat;
    private View.OnClickListener listener;
    private OnItemClickListener itemListener;
    //public ChatRecyclerAdapter(List<Chats> chatList, EstadoRecyclerAdapter.OnItemClickListener listener){
     //   this.chatList = chatList;
      //  this.itemListener = (OnItemClickListener) listener;


    //}

    public ChatRecyclerAdapter(RealmResults<Chats> realmChat, Context baseContext, OnItemClickListener onItemClickListener) {
        this.realmChat = realmChat;
        this.itemListener = (OnItemClickListener) listener;
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
        holder.assignDataChat(realmChat.get(position));
    }

    @Override
    public int getItemCount() {
        return realmChat.size();
    }

    @Override
    public void onClick(View view) {

    }
    public interface OnItemClickListener{
        void onItemClick(String name, int position);


    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder{
        ImageView imagenChat;
        TextView nombreChat;
        TextView mensajeChat;
        TextView horaChat;

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);
            imagenChat = (ImageView) itemView.findViewById(R.id.imageViewChat);
            nombreChat = (TextView) itemView.findViewById(R.id.textViewNombreChat);
            mensajeChat = (TextView) itemView.findViewById(R.id.textViewMensajeChat);
            horaChat = (TextView) itemView.findViewById(R.id.textViewHoraChat);


        }


        public void assignDataChat(Chats chats) {
            this.nombreChat.setText(chats.getNombreChat());
            if (chats.getMensajes().size() == 0){
                this.mensajeChat.setText("");
                this.horaChat.setText("");
            }else{
                Mensaje ultimoMensaje = chats.getMensajes().get(chats.getMensajes().size() - 1);
                this.mensajeChat.setText(ultimoMensaje.getMensaje());
                this.horaChat.setText(ultimoMensaje.getTiempo().toString());
            }

            this.nombreChat.setText(chats.getNombreChat());


            this.imagenChat.setImageResource(chats.getImagen());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onItemClick(chats.getNombreChat(),getAdapterPosition());

                }
            });
        }
    }



}

