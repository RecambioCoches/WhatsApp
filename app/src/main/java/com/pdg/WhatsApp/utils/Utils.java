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

public class    Utils {

    public static String nombreGlobal = "";
    public static String mensajeGlobal = "";
    public static List<User> getDummyDataUsers() {

        List<User> listUsers = new ArrayList<>();

        listUsers.add(new User("Persona1","Grupo1","persona1@gmail.com","password1"));
        listUsers.add(new User("Persona2","","persona2@gmail.com","password2"));
        listUsers.add(new User("Persona3","Grupo3","persona3@gmail.com","password3"));
        listUsers.add(new User("Persona4","Grupo4","persona4@gmail.com","password4"));
        return listUsers;
    }

    public static List<Estado> getDummyDataEstado(){
        List<Estado> listEstados = new ArrayList<>();

        listEstados.add(new Estado(R.drawable.chico, "Asier Martínez", "Hace 30 minutos"));
        listEstados.add(new Estado(R.drawable.mujer, "Arantxa Moriones", "Hace 6 horas"));
        listEstados.add(new Estado(R.drawable.chico, "David Pérez", "Hace 20 horas"));
        return listEstados;



    }

    public static List<Llamada> getDummyDataLlamada(){
        List<Llamada> listLlamadas = new ArrayList<>();

        listLlamadas.add(new Llamada(R.drawable.nina, "María Álvarez", "ayer", "Perdida"));
        listLlamadas.add(new Llamada(R.drawable.chico_1, "Pablo Fernández", "5/1/2023", "Saliente"));
        listLlamadas.add(new Llamada(R.drawable.mujer_1, "Iratxe Aldabe", "29/10/2022", "Entrante"));
        listLlamadas.add(new Llamada(R.drawable.hijo, "Juan", "15/7/2020", "Saliente"));
        return listLlamadas;

    }

    public static List<Chats> getDummyDataChats(){
        List<Chats> listChats = new ArrayList<>();

        RealmList<String> ChatP1P2 = new RealmList<>();
        ChatP1P2.add("Persona1");
        ChatP1P2.add("Persona2");

        RealmList<String> ChatP1P3 = new RealmList<>();
        ChatP1P3.add("Persona1");
        ChatP1P3.add("Persona3");


        RealmList<String> ChatP1P4 = new RealmList<>();
        ChatP1P4.add("Persona1");
        ChatP1P4.add("Persona4");


        RealmList<String> Grupo2DAM = new RealmList<>();
        Grupo2DAM.add("Persona1");
        Grupo2DAM.add("Persona2");
        Grupo2DAM.add("Persona3");



        RealmList<Mensaje> mensajesP1P2 = new RealmList<>();
        mensajesP1P2.add(new Mensaje("Hola","Persona2"));
        mensajesP1P2.add(new Mensaje("¿Que tal?","Persona1"));
        mensajesP1P2.add(new Mensaje("Aqui estamos","Persona2"));
        mensajesP1P2.add(new Mensaje("Todo bien","Persona2"));


        RealmList<Mensaje> mensajesP1P3 = new RealmList<>();
        mensajesP1P3.add(new Mensaje("Cuando era el examen de Moviles???","Persona1"));
        mensajesP1P3.add(new Mensaje("Noo me acuerdo, puede que mañana :v","Persona3"));
        mensajesP1P3.add(new Mensaje("¿Como no te puedes acordar?","Persona1"));
        mensajesP1P3.add(new Mensaje("Me di un golpe en la cabeza","Persona3"));

        RealmList<Mensaje> mensajesP1P4 = new RealmList<>();
        mensajesP1P4.add(new Mensaje("Buenos dias","Persona1"));
        mensajesP1P4.add(new Mensaje("Que pasa","Persona4"));
        mensajesP1P4.add(new Mensaje("Te recuerdo que me tienes que pagar el alquiler.","Persona1"));
        mensajesP1P4.add(new Mensaje("Va","Persona4"));

        RealmList<Mensaje> mensajesGrupo2DAM = new RealmList<>();
        mensajesGrupo2DAM.add(new Mensaje("Buenos dias Chicos","Persona1"));
        mensajesGrupo2DAM.add(new Mensaje("Buenas","Persona2"));
        mensajesGrupo2DAM.add(new Mensaje("Holaaaaaa","Persona3"));
        mensajesGrupo2DAM.add(new Mensaje("Que quereis hacer hoy?","Persona1"));


        Chats c = new Chats("María Álvarez",mensajesP1P2,R.drawable.nina,ChatP1P2 ,false,0);
        Chats c2 = new Chats("Francisco Flores",mensajesP1P3,R.drawable.chico,ChatP1P3,false ,0);
        Chats c3 = new Chats("Carolina Gonzalez",mensajesP1P4,R.drawable.mujer_1,ChatP1P4 ,false,0);

        Chats grupal = new Chats("Grupo 2 Dam",mensajesGrupo2DAM,R.drawable.diversidad,Grupo2DAM,true ,0);

        listChats.add(c);
        listChats.add(c2);
        listChats.add(c3);
        listChats.add(grupal);

        return listChats;
    }
}
