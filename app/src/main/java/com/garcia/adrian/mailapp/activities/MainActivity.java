package com.garcia.adrian.mailapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.adapter.CorreoAdapter;
import com.garcia.adrian.mailapp.model.Correo;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CorreoAdapter adapter;
    private List<Correo> correos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        correos= getAllCorreo();
        adapter= new CorreoAdapter(correos, R.layout.item_row, this, new CorreoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Correo correo, int position) {
                ////TODO: Al hace click, que se copie el contenido en el otro fragment!!
                Toast.makeText(MainActivity.this, "Pulsado correo nº "+ position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }


    private List<Correo> getAllCorreo() {
        return Arrays.asList(
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("rrhh@miempresa.com", "Oferta de emppleo", "Mi empresa SL ha visto su Curriculum Vitae y desea tener una entrevista de trabajo con usted para el día 25/11/18. Deseamos tenerte en nuestra plantilla de trabajo."),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente"),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente")

        );
    }
}