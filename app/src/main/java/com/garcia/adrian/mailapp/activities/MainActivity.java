package com.garcia.adrian.mailapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.fragments.FragmentContenido;
import com.garcia.adrian.mailapp.fragments.FragmentCorreo;
import com.garcia.adrian.mailapp.model.Correo;


public class MainActivity extends AppCompatActivity implements FragmentCorreo.OnMailSent{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onChange (Correo correo) {
        //Toast.makeText(MainActivity.this, "Pulsado correo. Titulo: "+ correo.getTitulo(), Toast.LENGTH_SHORT).show();

        FragmentContenido f= (FragmentContenido) getSupportFragmentManager().findFragmentById(R.id.fragmentContenido);

        if (f!=null){
            //Toast.makeText(MainActivity.this, "ENCONTRADO", Toast.LENGTH_SHORT).show();
            f.onCorreoChange(correo);
        } else {
            //Toast.makeText(MainActivity.this, "NO ENCONTRADO", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, CuerpoActivity.class);

            intent.putExtra("MAIL_TITULO", correo.getTitulo());
            intent.putExtra("MAIL_FROM", correo.getSujeto());
            intent.putExtra("MAIL_CUERPO", correo.getCuerpo());

            startActivity(intent);
        }
    }

}