package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Estado extends RealmObject {
    @PrimaryKey
    private int id;

    private int foto;
    private String nombreUsuario;
    private String tiempo;

    public Estado() {
    }

    public Estado(int foto, String nombreUsuario, String tiempo) {
        this.id = MyApplication.estadoId.incrementAndGet();
        this.foto = foto;
        this.nombreUsuario = nombreUsuario;
        this.tiempo = tiempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
