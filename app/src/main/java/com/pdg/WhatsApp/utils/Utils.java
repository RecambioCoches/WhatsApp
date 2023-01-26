package com.pdg.WhatsApp.utils;

import com.pdg.WhatsApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<User> getDummyData() {
        List<User> list = new ArrayList<User>();

        list.add(new User(""));

        return list;
    }
}
