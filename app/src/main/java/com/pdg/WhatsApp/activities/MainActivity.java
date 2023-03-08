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
    String name,mensaje,nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        realm = Realm.getDefaultInstance();


        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        Bundle b = getIntent().getExtras();
        name = b.getString("name");
        Bundle x = getIntent().getExtras();
        mensaje = x.getString("mensaje");
        nombre = x.getString("usuario");

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.estados));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.chats));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.llamadas));

        viewPager = findViewById(R.id.viewPager);
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
        ChatFragment michat = (ChatFragment) myViewPagerAdapter.getItem(1);
        michat.SetNombre(name);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
        if (!Objects.equals(Utils.mensajeGlobal, "")){
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
        createNotificationChannel();
        if(notificacionID == null){notificacionID = 0;}else{notificacionID += 1;}
        Intent intent = new Intent(this, Chat.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.whatsapp)
                .setContentTitle(Utils.nombreGlobal)
                .setContentText(Utils.mensajeGlobal)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(notificacionID, notificacion.build());
    }
}