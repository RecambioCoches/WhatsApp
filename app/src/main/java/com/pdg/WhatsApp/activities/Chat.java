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
import android.widget.Button;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.ChatRecyclerAdapter;
import com.pdg.WhatsApp.adapters.MensajeRecyclerAdapter;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.Mensaje;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class Chat extends AppCompatActivity {

    private static final String CHANNEL_ID = "Canal de Notificaciones";
    NotificationManager notificationManager;
    Integer notificacionID;

    //CREACIÓN DE UNA FUNCIÓN CANAL PARA LAS NOTIFICACIONES
    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Mi Canal";
            String description = "He creado este canal para mostrar notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    Realm realm;
    RealmResults<Mensaje> realmMensaje;
    RecyclerView recyclerView;
    MensajeRecyclerAdapter mensajeRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //LLAMADA A LA CREACIÓN DE LA NOTIFICACIÓN (EN NUESTRO CASO CUANDO SE PULSE EL BOTÓN DE MANDAR MENSAJE)
        createNotificationChannel();
        if(notificacionID == null){notificacionID = 0;}else{notificacionID += 1;}

        //INTENT QUE TE LLEVA AL CHAT DEL CUAL TE HA LLEGADO LA NOTIFICACIÓN (SOLO ÚTIL SI USAMOS FIREBASE)
        Intent intent = new Intent(this, Chat.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        //CREACIÓN DE LA PROPIA NOTIFICACIÓN, CON SUS ATRIBUTOS DEPENDIENDO QUIEN TE MANDA EL MENSAJE
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this, CHANNEL_ID)

            //LOGO DE WHATSAPP O FOTO DE QUIEN TE MANDA LA NOTIFICACIÓN
            .setSmallIcon(R.drawable.whatsapp)
            //NOMBRE DE QUIEN TE MANDA LA NOTIFICACIÓN
            .setContentTitle("Nombre del usuario")
            //CONTENIDO DEL MENSAJE QUE RECIBES DE QUIEN TE MANDA LA NOTIFICACIÓN
            .setContentText("Mensaje")
            //ESCOGEMOS LA PRIORIDAD DE NUESTRO MENSAJE DE NOTIFICACION
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            //ELEGIMOS QUE TIPO DE MENSAJE SE MOSTRARÁ
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            //LE METEMOS AL INTENT SELECCINADO EL INTENT PENDIENTE (SOLO SI USAMOS FIREBASE)
            .setContentIntent(pendingIntent)
            //PONEMOS LA AUTOCANCELACIÓN A TRUE (SOLO SI USAMOS FIREBASE)
            .setAutoCancel(true);

        //FINALMENTE LANZAMOS LA NOTIFICACIÓN
        notificationManager.notify(notificacionID, notificacion.build());


        //Realm y cosas del recycler

        realm = Realm.getDefaultInstance();
        realmMensaje = realm.where(Mensaje.class).findAll();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerMensajeId);


        mensajeRecyclerAdapter = new MensajeRecyclerAdapter(realmMensaje, getBaseContext(), new MensajeRecyclerAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(String name, int position) {

            }


        });

        recyclerView.setAdapter(mensajeRecyclerAdapter);
        recyclerView.setAdapter(mensajeRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }




}