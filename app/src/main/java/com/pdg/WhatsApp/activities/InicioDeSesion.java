package com.pdg.WhatsApp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdg.WhatsApp.R;
import com.pdg.WhatsApp.model.Chats;
import com.pdg.WhatsApp.model.User;
import com.pdg.WhatsApp.utils.Utils;

import java.util.List;

import io.realm.Realm;

public class InicioDeSesion extends AppCompatActivity {
    Realm realm;
    EditText txtUsername,txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_de_sesion);
        realm = Realm.getDefaultInstance();

        //realm.beginTransaction();
        //realm.deleteAll();
        //realm.commitTransaction();


        if (realm.isEmpty()){

            realm.beginTransaction();
            realm.copyToRealm(Utils.getDummyDataChats());
            realm.copyToRealm(Utils.getDummyDataUsers());
            realm.copyToRealm(Utils.getDummyDataLlamada());
            realm.copyToRealm(Utils.getDummyDataEstado());
            realm.commitTransaction();
        }




        txtUsername = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> {
            User user = realm.where(User.class).equalTo("nombre", txtUsername.getText().toString()).findFirst();
            if (user == null) Toast.makeText(this, "Ese usuario no existe", Toast.LENGTH_SHORT).show();
            else {
                if (!user.getPassword().equals(txtPassword.getText().toString()))
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        Intent intent = new Intent(InicioDeSesion.this, MainActivity.class);
                        intent.putExtra("id", user.getId());
                        intent.putExtra("name", user.getNombre());
                        txtUsername.setText("");
                        txtPassword.setText("");
                        startActivity(intent);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}