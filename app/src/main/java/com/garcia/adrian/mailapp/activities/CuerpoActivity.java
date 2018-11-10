package com.garcia.adrian.mailapp.activities;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.fragments.FragmentContenido;
import com.garcia.adrian.mailapp.fragments.FragmentCorreo;
import com.garcia.adrian.mailapp.model.Correo;

public class CuerpoActivity extends AppCompatActivity implements FragmentContenido.OnMailSent {

    FragmentContenido contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuerpo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ////TODO: Hacer que funcione el maldito fragment aquí...

        contenido = new FragmentContenido();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, contenido).commit();
    }

    @Override
    public void onChange () {
        contenido.onCorreoChange(
                getIntent().getStringExtra("MAIL_TITULO"),
                getIntent().getStringExtra("MAIL_FROM"),
                getIntent().getStringExtra("MAIL_CUERPO")
        );
    }
}