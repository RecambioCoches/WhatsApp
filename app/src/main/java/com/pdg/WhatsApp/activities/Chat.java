package com.pdg.WhatsApp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.MensajeRecyclerAdapter;
import com.pdg.WhatsApp.fragments.ChatFragment;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;
import com.pdg.WhatsApp.utils.Utils;

import io.realm.Realm;

public class Chat extends AppCompatActivity {


    Realm realm;
    RecyclerView recyclerView;
    MensajeRecyclerAdapter mensajeRecyclerAdapter;
    Button buttonSend;
    EditText editTextNuevoMensaje;
    Integer chatId,imagenCabecera;
    String nombreUserLog,nuevoMensaje,nombreCabecera;
    Chats chat;
    TextView nombreChat;
    ImageView imagenChat;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        editTextNuevoMensaje = findViewById(R.id.editTextNuevoMensaje);
        buttonSend = findViewById(R.id.buttonSend);
        Bundle b = getIntent().getExtras();
        int id = b.getInt("id");
        nombreUserLog =  b.getString("name");
        imagenCabecera = b.getInt("imagen");
        nombreCabecera =  b.getString("nameCabecera");
        chatId = id;
        realm = Realm.getDefaultInstance();


        chat = realm.where(Chats.class).equalTo("id",chatId).findFirst();
        recyclerView = findViewById(R.id.recyclerMensajeId);

        nombreChat = findViewById(R.id.textViewNombreCabecera);
        imagenChat = findViewById(R.id.imageView);

        nombreChat.setText(nombreCabecera);
        imagenChat.setImageResource(imagenCabecera);

        mensajeRecyclerAdapter = new MensajeRecyclerAdapter(chat.getMensajes(), nombreUserLog);

        recyclerView.setAdapter(mensajeRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        buttonSend.setOnClickListener(v -> {
            nuevoMensaje = editTextNuevoMensaje.getText().toString();
            if (!nuevoMensaje.strip().equals("")){
                realm.beginTransaction();
                Mensaje mensaje = new Mensaje(nuevoMensaje,nombreUserLog);
                chat.getMensajes().add(mensaje);
                mensajeRecyclerAdapter.notifyDataSetChanged();
                Utils.nombreGlobal = nombreUserLog;
                Utils.mensajeGlobal = nuevoMensaje;
                realm.copyToRealmOrUpdate(chat);
                realm.commitTransaction();
                editTextNuevoMensaje.setText("");
            }
        });


    }
}