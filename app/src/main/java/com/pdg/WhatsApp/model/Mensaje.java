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
    private int idUsuario;


    public Mensaje() {
    }

    public Mensaje(String mensaje,int idUsuario) {
        this.id = MyApplication.userId.incrementAndGet();
        this.mensaje = mensaje;
        tiempo = Calendar.getInstance().getTime();
        this.idUsuario = idUsuario;

    }
}
