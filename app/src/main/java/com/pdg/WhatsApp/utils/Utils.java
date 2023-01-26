package com.pdg.WhatsApp.utils;

import com.pdg.WhatsApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<User> getDummyData() {
        List<User> list = new ArrayList<User>();

        list.add(new User("Persona1","Grupo1","persona1@gmail.com","password1"));
        list.add(new User("Persona2","","persona2@gmail.com","password2"));
        list.add(new User("Persona3","Grupo3","persona3@gmail.com","password3"));
        list.add(new User("Persona4","Grupo4","persona4@gmail.com","password4"));
        list.add(new User("Persona5","","persona5@gmail.com","password5"));
        list.add(new User("Persona6","Grupo6","persona6@gmail.com","password6"));
        list.add(new User("Persona7","Grupo7","persona7@gmail.com","password7"));
        return list;
    }
}
