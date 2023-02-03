package com.pdg.WhatsApp.utils;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Estado;
import com.pdg.WhatsApp.model.Llamada;
import com.pdg.WhatsApp.model.Mensaje;
import com.pdg.WhatsApp.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;

public class Utils {

    public static List<User> getDummyDataUsers() {
        List<User> listUsers = new ArrayList<User>();

        listUsers.add(new User("Persona1","Grupo1","persona1@gmail.com","password1"));
        listUsers.add(new User("Persona2","","persona2@gmail.com","password2"));
        listUsers.add(new User("Persona3","Grupo3","persona3@gmail.com","password3"));
        listUsers.add(new User("Persona4","Grupo4","persona4@gmail.com","password4"));
        listUsers.add(new User("Persona5","","persona5@gmail.com","password5"));
        listUsers.add(new User("Persona6","Grupo6","persona6@gmail.com","password6"));
        listUsers.add(new User("Persona7","Grupo7","persona7@gmail.com","password7"));
        listUsers.add(new User("1","1","1@gmail.com","1"));
        return listUsers;
    }

    public static List<Estado> getDummyDataEstado(){
        List<Estado> listEstados = new ArrayList<Estado>();

        listEstados.add(new Estado(R.drawable.chico, "Asier Martínez", "Hace 30 minutos"));
        listEstados.add(new Estado(R.drawable.mujer, "Arantxa Moriones", "Hace 6 horas"));
        listEstados.add(new Estado(R.drawable.chico, "David Pérez", "Hace 20 horas"));
        return listEstados;



    }

    public static List<Llamada> getDummyDataLlamada(){
        List<Llamada> listLlamadas = new ArrayList<Llamada>();

        listLlamadas.add(new Llamada(R.drawable.nina, "María Álvarez", "ayer", "Perdida"));
        listLlamadas.add(new Llamada(R.drawable.chico_1, "Pablo Fernández", "5/1/2023", "Saliente"));
        listLlamadas.add(new Llamada(R.drawable.mujer_1, "Iratxe Aldabe", "29/10/2022", "Entrante"));
        listLlamadas.add(new Llamada(R.drawable.hijo, "Juan", "15/7/2020", "Saliente"));
        return listLlamadas;

    }

    public static List<Chats> getDummyDataChats(){
        List<Chats> listChats = new ArrayList<Chats>();
        RealmList<String> Participantes1 = new RealmList<>();
        Participantes1.add("Persona1");
        Participantes1.add("Persona2");

        RealmList<String> Participantes2 = new RealmList<>();
        Participantes2.add("Persona1");
        Participantes2.add("Persona4");


        RealmList<String> Participantes3 = new RealmList<>();
        Participantes2.add("Persona1");
        Participantes2.add("Persona3");


        listChats.add(new Chats("María Álvarez",new RealmList<Mensaje>(),R.drawable.nina,Participantes1 ));
        listChats.add(new Chats("Francisco Flores",new RealmList<Mensaje>(),R.drawable.nina,Participantes2 ));
        listChats.add(new Chats("Carolina Gonzalez",new RealmList<Mensaje>(),R.drawable.nina,Participantes3 ));


        return listChats;
    }
}
