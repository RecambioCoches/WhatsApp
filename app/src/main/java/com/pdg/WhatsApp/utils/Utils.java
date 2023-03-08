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

    public static String nombreGlobal,mensajeGlobal = "";
    public static List<User> getDummyDataUsers() {

        List<User> listUsers = new ArrayList<>();

        listUsers.add(new User("Fernando","Grupo1","fernando@gmail.com","password1"));
        listUsers.add(new User("Lucia","","lucia@gmail.com","password2"));
        listUsers.add(new User("Esteban","Grupo3","esteban@gmail.com","password3"));
        listUsers.add(new User("Amaia","Grupo4","amaia@gmail.com","password4"));
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
        ChatP1P2.add("Fernando");
        ChatP1P2.add("Lucia");

        RealmList<String> ChatP1P3 = new RealmList<>();
        ChatP1P3.add("Fernando");
        ChatP1P3.add("Esteban");


        RealmList<String> ChatP1P4 = new RealmList<>();
        ChatP1P4.add("Fernando");
        ChatP1P4.add("Amaia");


        RealmList<String> Grupo2DAM = new RealmList<>();
        Grupo2DAM.add("Fernando");
        Grupo2DAM.add("Lucia");
        Grupo2DAM.add("Esteban");



        RealmList<Mensaje> mensajesP1P2 = new RealmList<>();
        mensajesP1P2.add(new Mensaje("Hola","Lucia"));
        mensajesP1P2.add(new Mensaje("¿Que tal?","Fernando"));
        mensajesP1P2.add(new Mensaje("Aqui estamos","Lucia"));
        mensajesP1P2.add(new Mensaje("Todo bien","Lucia"));


        RealmList<Mensaje> mensajesP1P3 = new RealmList<>();
        mensajesP1P3.add(new Mensaje("Cuando era el examen de Moviles???","Fernando"));
        mensajesP1P3.add(new Mensaje("Noo me acuerdo, puede que mañana :v","Esteban"));
        mensajesP1P3.add(new Mensaje("¿Como no te puedes acordar?","Fernando"));
        mensajesP1P3.add(new Mensaje("Me di un golpe en la cabeza","Esteban"));

        RealmList<Mensaje> mensajesP1P4 = new RealmList<>();
        mensajesP1P4.add(new Mensaje("Buenos dias","Fernando"));
        mensajesP1P4.add(new Mensaje("Que pasa","Amaia"));
        mensajesP1P4.add(new Mensaje("Te recuerdo que me tienes que pagar el alquiler.","Fernando"));
        mensajesP1P4.add(new Mensaje("Va","Amaia"));

        RealmList<Mensaje> mensajesGrupo2DAM = new RealmList<>();
        mensajesGrupo2DAM.add(new Mensaje("Buenos dias Chicos","Fernando"));
        mensajesGrupo2DAM.add(new Mensaje("Buenas","Lucia"));
        mensajesGrupo2DAM.add(new Mensaje("Holaaaaaa","Esteban"));
        mensajesGrupo2DAM.add(new Mensaje("Que quereis hacer hoy?","Fernando"));


        Chats chat1 = new Chats("Chat1",mensajesP1P2,R.drawable.nina,ChatP1P2 ,false,0);
        Chats chat2 = new Chats("Chat2",mensajesP1P3,R.drawable.chico,ChatP1P3,false ,0);
        Chats chat3 = new Chats("Chat3",mensajesP1P4,R.drawable.mujer_1,ChatP1P4 ,false,0);

        Chats grupal = new Chats("2ºDAM",mensajesGrupo2DAM,R.drawable.diversidad,Grupo2DAM,true ,0);

        listChats.add(chat1);
        listChats.add(chat2);
        listChats.add(chat3);
        listChats.add(grupal);

        return listChats;
    }
}
