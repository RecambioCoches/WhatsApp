package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;


import java.util.Date;
import java.util.Calendar;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mensaje extends RealmObject {
    @PrimaryKey
    private int id;

    private String mensaje;
    private Date tiempo;
    private String nombreUsuario;



    public Mensaje() {
    }

    public Mensaje(String mensaje,String nombreUsuario) {
        this.id = MyApplication.userId.incrementAndGet();
        this.mensaje = mensaje;
        tiempo = Calendar.getInstance().getTime();
        this.nombreUsuario = nombreUsuario;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
