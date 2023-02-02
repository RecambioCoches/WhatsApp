package com.pdg.WhatsApp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Chats;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChatRecyclerAdapter extends RecyclerView.Adapter <ChatRecyclerAdapter.RecyclerDataHolder> implements View.OnClickListener {
    List<Chats> chatList;
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
        //view.setOnClickListener(this);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataHolder holder, int position) {
        holder.assignDataChat(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View view) {

    }
    public interface OnItemClickListener{
        void onItemClick(String name, int position);


    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder{

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);



        }


        public void assignDataChat(Chats chats) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onItemClick(chats.getNombreChat(),getAdapterPosition());

                }
            });
        }
    }



}

