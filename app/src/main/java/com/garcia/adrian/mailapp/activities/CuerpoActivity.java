package com.garcia.adrian.mailapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.fragments.FragmentContenido;

public class CuerpoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuerpo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ////TODO: Hacer que funcione el maldito fragment aquí...

        FragmentContenido contenido = new FragmentContenido();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, contenido).commit();

        Log.e("INFO_A_POSTERIORI", "Funciona??");

        /*if (contenido!=null)
            contenido.onCorreoChange(
                    getIntent().getStringExtra("MAIL_TITULO"),
                    getIntent().getStringExtra("MAIL_FROM"),
                    getIntent().getStringExtra("MAIL_CUERPO")
            );*/

    }
}