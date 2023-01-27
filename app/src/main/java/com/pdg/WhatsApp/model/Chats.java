package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;

import java.util.ArrayList;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Chats extends RealmObject {
    @PrimaryKey
    private int id;

    private String nombreChat;
    private ArrayList<Mensaje> mensajes;


    public Chats() {
    }

    public Chats(String nombreChat,ArrayList<Mensaje> mensajes) {
        this.id = MyApplication.userId.incrementAndGet();
        this.nombreChat = nombreChat;
        this.mensajes = mensajes;

    }
}
