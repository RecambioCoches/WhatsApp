package com.pdg.WhatsApp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.adapters.MyViewPagerAdapter;
import com.pdg.WhatsApp.fragments.ChatFragment;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.utils.Utils;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements ChatFragment.DataListener {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    MyViewPagerAdapter myViewPagerAdapter;
    Realm realm;
    String name;
    String mensaje;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        realm = Realm.getDefaultInstance();


        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //Recibimos el usuario que ha hecho login
        Bundle b = getIntent().getExtras();
        name = b.getString("name");

        //Recibimos el mensaje del usuario que ha mandado el mensaje
        Bundle x = getIntent().getExtras();
        mensaje = x.getString("mensaje");
        nombre = x.getString("usuario");

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.chats));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.estados));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.llamadas));

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(0);
        ChatFragment michat = (ChatFragment) myViewPagerAdapter.getItem(0);
        michat.SetNombre(name);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        if (Utils.mensajeGlobal != ""){
            notificacion();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.cerrar_sesion:

                startActivity(new Intent(MainActivity.this, InicioDeSesion.class));
                return true;

            case R.id.camara:
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void sendData(Integer Data) {
        realm = Realm.getDefaultInstance();
    }

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
    private void notificacion(){
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
                .setContentTitle(Utils.nombreGlobal)
                //CONTENIDO DEL MENSAJE QUE RECIBES DE QUIEN TE MANDA LA NOTIFICACIÓN
                .setContentText(Utils.mensajeGlobal)
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
    }
}