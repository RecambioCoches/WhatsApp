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

        // Lista conversaciones de la persona 1 con otras personas.
        RealmList<String> Participantes1 = new RealmList<>();
        Participantes1.add("Persona1");
        Participantes1.add("Persona2");

        RealmList<String> Participantes2 = new RealmList<>();
        Participantes2.add("Persona1");
        Participantes2.add("Persona3");


        RealmList<String> Participantes3 = new RealmList<>();
        Participantes3.add("Persona1");
        Participantes3.add("Persona4");

        RealmList<String> Participantes4 = new RealmList<>();
        Participantes4.add("Persona1");
        Participantes4.add("Persona5");

        RealmList<String> Participantes5 = new RealmList<>();
        Participantes4.add("Persona1");
        Participantes4.add("Persona6");

        RealmList<String> Participantes6 = new RealmList<>();
        Participantes5.add("Persona1");
        Participantes5.add("Persona3");

        RealmList<String> Participantes7 = new RealmList<>();
        Participantes6.add("Persona1");
        Participantes6.add("Persona7");

        RealmList<String> Participantes8 = new RealmList<>();
        Participantes8.add("Persona1");
        Participantes8.add("Persona3");
        Participantes8.add("Persona7");
        Participantes8.add("Persona5");

        //Mensajes de Persona1 con Persona 2
        RealmList<Mensaje> mensaje1 = new RealmList<Mensaje>();
        mensaje1.add(new Mensaje("Hola","Persona2"));
        mensaje1.add(new Mensaje("¿Que tal?","Persona1"));
        mensaje1.add(new Mensaje("Aqui estamos","Persona2"));
        mensaje1.add(new Mensaje("Todo bien","Persona2"));


        //Mensajes de Persona1 con Persona 3
        RealmList<Mensaje> mensaje2 = new RealmList<Mensaje>();
        mensaje2.add(new Mensaje("Cuando era el examen de Moviles???","Persona1"));
        mensaje2.add(new Mensaje("Noo me acuerdo, puede que mañana :v","Persona3"));
        mensaje2.add(new Mensaje("¿Como no te puedes acordar?","Persona1"));
        mensaje2.add(new Mensaje("Me di un golpe en la cabeza","Persona3"));

        //Mensajes de Persona1 con Persona 4
        RealmList<Mensaje> mensaje3 = new RealmList<Mensaje>();
        mensaje3.add(new Mensaje("Buenos dias","Persona1"));
        mensaje3.add(new Mensaje("Que pasa","Persona4"));
        mensaje3.add(new Mensaje("Te recuerdo que me tienes que pagar el alquiler.","Persona1"));
        mensaje3.add(new Mensaje("Va","Persona4"));

        Chats c = new Chats("María Álvarez",mensaje1,R.drawable.nina,Participantes1 );
        //lista de chats persona1 con otras personas
        listChats.add(c);
        listChats.add(new Chats("Francisco Flores",mensaje2,R.drawable.chico,Participantes2 ));
        listChats.add(new Chats("Carolina Gonzalez",mensaje3,R.drawable.mujer_1,Participantes3 ));
        listChats.add(new Chats("David Salas",new RealmList<Mensaje>(),R.drawable.hijo,Participantes4 ));
        listChats.add(new Chats("Pablo Perez",new RealmList<Mensaje>(),R.drawable.avatardehombre,Participantes5 ));
        listChats.add(new Chats("Iker Lopez",new RealmList<Mensaje>(),R.drawable.carafeliz,Participantes6 ));
        listChats.add(new Chats("Sofia Cancelo",new RealmList<Mensaje>(),R.drawable.mujersoltera,Participantes7 ));
        listChats.add(new Chats("Grupo 2 Dam",new RealmList<Mensaje>(),R.drawable.diversidad,Participantes8 ));

        RealmList<String> ParticipantesdeDavid1 = new RealmList<>();
        ParticipantesdeDavid1.add("Persona2");
        ParticipantesdeDavid1.add("Persona1");

        RealmList<String> ParticipantesdeDavid2 = new RealmList<>();
        ParticipantesdeDavid2.add("Persona2");
        ParticipantesdeDavid2.add("Persona4");


        RealmList<String> ParticipantesdeDavid3 = new RealmList<>();
        ParticipantesdeDavid3.add("Persona2");
        ParticipantesdeDavid3.add("Persona3");

        RealmList<String> ParticipantesdeDavid4 = new RealmList<>();
        ParticipantesdeDavid4.add("Persona2");
        ParticipantesdeDavid4.add("Persona5");

        RealmList<String> ParticipantesdeDavid5 = new RealmList<>();
        ParticipantesdeDavid5.add("Persona2");
        ParticipantesdeDavid5.add("Persona6");

        RealmList<String> ParticipantesdeDavid6 = new RealmList<>();
        ParticipantesdeDavid6.add("Persona2");
        ParticipantesdeDavid6.add("Persona7");

        RealmList<String> ParticipantesdeDavid7 = new RealmList<>();
        ParticipantesdeDavid7.add("Persona2");
        ParticipantesdeDavid7.add("Persona7");
        ParticipantesdeDavid7.add("Persona5");

        RealmList<String> ParticipantesdeDavid8 = new RealmList<>();
        ParticipantesdeDavid8.add("Persona2");
        ParticipantesdeDavid8.add("Persona1");
        ParticipantesdeDavid8.add("Persona6");
        ParticipantesdeDavid8.add("Persona5");

        //lista de chats persona1 con otras personas
        listChats.add(c);
        listChats.add(new Chats("Juan",new RealmList<Mensaje>(),R.drawable.servicioalcliente,ParticipantesdeDavid2 ));
        listChats.add(new Chats("Felipe Gonzalez",new RealmList<Mensaje>(),R.drawable.avatar,ParticipantesdeDavid3 ));
        listChats.add(new Chats("Gabriel Fernandez",new RealmList<Mensaje>(),R.drawable.avatardehombre,ParticipantesdeDavid4 ));
        listChats.add(new Chats("Pedri Gonzalez",new RealmList<Mensaje>(),R.drawable.evaluar,ParticipantesdeDavid5 ));
        listChats.add(new Chats("Irene Elorz",new RealmList<Mensaje>(),R.drawable.mujer_1,ParticipantesdeDavid6 ));
        listChats.add(new Chats("Familia",new RealmList<Mensaje>(),R.drawable.personas,ParticipantesdeDavid7 ));
        listChats.add(new Chats("Grupo de Bingo",new RealmList<Mensaje>(),R.drawable.diversidad,ParticipantesdeDavid8 ));




        return listChats;
    }
}
