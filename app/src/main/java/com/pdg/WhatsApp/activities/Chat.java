package com.pdg.WhatsApp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.ChatRecyclerAdapter;
import com.pdg.WhatsApp.adapters.MensajeRecyclerAdapter;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;
import com.pdg.WhatsApp.utils.Utils;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class Chat extends AppCompatActivity {


    Realm realm;
    RealmResults<Mensaje> realmMensaje;
    RecyclerView recyclerView;
    MensajeRecyclerAdapter mensajeRecyclerAdapter;
    Button buttonSend;
    EditText editTextNuevoMensaje;
    Integer chatId;
    String nombreUserLog;
    String nuevoMensaje;
    Chats c;
    String nombreCabecera;
    Integer imagenCabecera;
    TextView nombreChat;
    ImageView imagenChat;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        editTextNuevoMensaje = (EditText) findViewById(R.id.editTextNuevoMensaje);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        //Realm y cosas del recycler
        Bundle b = getIntent().getExtras();
        int id = b.getInt("id");
        nombreUserLog =  b.getString("name");
        imagenCabecera = b.getInt("imagen");
        nombreCabecera =  b.getString("nameCabecera");
        chatId = id;
        realm = Realm.getDefaultInstance();


        c = realm.where(Chats.class).equalTo("id",chatId).findFirst();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerMensajeId);

        nombreChat = (TextView) findViewById(R.id.textViewNombreCabecera);
        imagenChat = (ImageView) findViewById(R.id.imageView);

        nombreChat.setText(nombreCabecera);
        imagenChat.setImageResource(imagenCabecera);

        mensajeRecyclerAdapter = new MensajeRecyclerAdapter(c.getMensajes(), nombreUserLog,imagenCabecera,nombreCabecera, new MensajeRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                String mensaje = editTextNuevoMensaje.getText().toString();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");


        recyclerView.setAdapter(mensajeRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        realm = Realm.getDefaultInstance();
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                nuevoMensaje = editTextNuevoMensaje.getText().toString();
                Mensaje mensaje = new Mensaje(nuevoMensaje,nombreUserLog);
                c.getMensajes().add(mensaje);
                mensajeRecyclerAdapter.notifyDataSetChanged();
                Utils.nombreGlobal = nombreUserLog;
                Utils.mensajeGlobal = nuevoMensaje;
                realm.copyToRealmOrUpdate(c);
                realm.commitTransaction();
                editTextNuevoMensaje.setText("");








            }
        });

    }
}