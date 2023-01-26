package com.pdg.WhatsApp.model;

import com.pdg.WhatsApp.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private int id;

    private String nombre;
    private String grupo;
    private String email;
    private String Password;

    public User() {
    }

    public User(String nombre, String grupo, String email, String password) {
        this.id = MyApplication.userId.incrementAndGet();
        this.nombre = nombre;
        this.grupo = grupo;
        this.email = email;
        this.Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
