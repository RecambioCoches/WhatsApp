package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Llamada extends RealmObject {
    @PrimaryKey
    private int id;

    private int foto;
    private String nombreUsuario;
    private String fecha;
    private String estadoLlamada;

    public Llamada() {
    }

    public Llamada(int foto, String nombreUsuario, String fecha, String estadoLlamada) {
        this.id = MyApplication.llamadaId.incrementAndGet();
        this.foto = foto;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.estadoLlamada = estadoLlamada;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoLlamada() {
        return estadoLlamada;
    }

    public void setEstadoLlamada(String estadoLlamada) {
        this.estadoLlamada = estadoLlamada;
    }
}
