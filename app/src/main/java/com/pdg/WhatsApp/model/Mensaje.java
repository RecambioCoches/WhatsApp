package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;


import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mensaje extends RealmObject {
    @PrimaryKey
    private int id;

    private String mensaje;
    private String tiempo;
    private String nombreUsuario;



    public Mensaje() {
    }

    public Mensaje(String mensaje,String nombreUsuario) {
        this.id = MyApplication.mensajeId.incrementAndGet();
        this.mensaje = mensaje;
        // Crear un objeto SimpleDateFormat para formatear la hora
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

// Obtener la hora y los minutos formateados y asignarlos a la variable tiempo
        this.tiempo = formatoHora.format(Calendar.getInstance().getTime());
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

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
