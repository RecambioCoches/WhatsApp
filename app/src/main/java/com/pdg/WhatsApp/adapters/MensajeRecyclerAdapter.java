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

import io.realm.Realm;
import io.realm.RealmResults;

public class MensajeRecyclerAdapter extends RecyclerView.Adapter <MensajeRecyclerAdapter.RecyclerDataHolder> implements View.OnClickListener {

    Realm realm;
    RealmResults<Mensaje> realmMensaje;
    private View.OnClickListener listener;
    private MensajeRecyclerAdapter.OnItemClickListener itemListener;
    //public ChatRecyclerAdapter(List<Chats> chatList, EstadoRecyclerAdapter.OnItemClickListener listener){
    //   this.chatList = chatList;
    //  this.itemListener = (OnItemClickListener) listener;


    //}

    public MensajeRecyclerAdapter(RealmResults<Mensaje> realmMensaje, Context baseContext, MensajeRecyclerAdapter.OnItemClickListener onItemClickListener) {
        this.realmMensaje = realmMensaje;
        this.itemListener = (MensajeRecyclerAdapter.OnItemClickListener) listener;
    }

    @NonNull
    @Override
    public MensajeRecyclerAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list,null,false);
        view.setOnClickListener(this);
        return new MensajeRecyclerAdapter.RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeRecyclerAdapter.RecyclerDataHolder holder, int position) {
        holder.assignDataChat(realmMensaje.get(position));
    }

    @Override
    public int getItemCount() {
        return realmMensaje.size();
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


        public void assignDataChat(Mensaje mensaje) {




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //itemListener.onItemClick(chats.getNombreChat(),getAdapterPosition());

                }
            });
        }
    }



}
