package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Chats extends RealmObject {
    @PrimaryKey
    private int id;

    private String nombreChat;
    private RealmList<Mensaje> mensajes;
    private RealmList<String> nombreUsers;
    private int imagen;


    public Chats() {
    }

    public Chats(String nombreChat, RealmList<Mensaje> mensajes, int imagen, RealmList<String> users) {
        this.id = MyApplication.chatId.incrementAndGet();

        this.nombreChat = nombreChat;
        this.mensajes = mensajes;
        this.imagen = imagen;
        this.nombreUsers = users;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreChat() {
        return nombreChat;
    }

    public void setNombreChat(String nombreChat) {
        this.nombreChat = nombreChat;
    }

    public RealmList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(RealmList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public RealmList<String> getNombreUsers() {
        return nombreUsers;
    }

    public void setNombreUsers(RealmList<String> nombreUsers) {
        this.nombreUsers = nombreUsers;
    }
}
