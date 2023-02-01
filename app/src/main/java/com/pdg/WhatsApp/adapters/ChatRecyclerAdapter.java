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

public class ChatRecyclerAdapter extends RecyclerView.Adapter <ChatRecyclerAdapter.RecyclerDataHolder> {
    List<Chats> chatList;
    public ChatRecyclerAdapter(List<Chats> chatList){
        this.chatList = chatList;


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
        holder.assignData(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder{

        public RecyclerDataHolder(@NonNull View itemView){
            super(itemView);

        }
    }

    public void assignData(Chats c){
        c.get
    }

}

