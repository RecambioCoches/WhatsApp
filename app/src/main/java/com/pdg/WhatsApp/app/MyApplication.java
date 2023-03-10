package com.pdg.WhatsApp.app;

import android.app.Application;

import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Estado;
import com.pdg.WhatsApp.model.Llamada;
import com.pdg.WhatsApp.model.Mensaje;
import com.pdg.WhatsApp.model.User;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {
    public static AtomicInteger userId = new AtomicInteger();
    public static AtomicInteger estadoId = new AtomicInteger();
    public static AtomicInteger llamadaId = new AtomicInteger();
    public static AtomicInteger chatId = new AtomicInteger();
    public static AtomicInteger mensajeId = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        userId = getIdByTable(realm, User.class);
        estadoId = getIdByTable(realm, Estado.class);
        llamadaId = getIdByTable(realm, Llamada.class);
        chatId = getIdByTable(realm, Chats.class);
        mensajeId = getIdByTable(realm, Mensaje.class);
        realm.close();
    }

    private void setUpRealmConfig(){
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        if (results.size()>0){
            return new AtomicInteger(results.max("id").intValue());
        }
        else{
            return new AtomicInteger(0);
        }
    }
}
