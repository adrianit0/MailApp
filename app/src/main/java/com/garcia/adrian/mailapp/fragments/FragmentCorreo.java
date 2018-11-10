package com.garcia.adrian.mailapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.activities.MainActivity;
import com.garcia.adrian.mailapp.adapter.CorreoAdapter;
import com.garcia.adrian.mailapp.model.Correo;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCorreo extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CorreoAdapter adapter;
    private List<Correo> correos;
    private List<Integer> colores;
    private OnNameSent callback;

    public FragmentCorreo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos el layout para este fragment

        // Nuevo contenido
        View view= inflater.inflate(R.layout.fragment_correos, container, false);

        recyclerView= view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        colores=getAllColor();
        correos= getAllCorreo();
        adapter= new CorreoAdapter(correos, R.layout.item_row, this.getActivity(), new CorreoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Correo correo, int position) {
                callback.onChange(correo);
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (OnNameSent) context;
        }catch (ClassCastException e){
            System.out.println("Error: deberia implementar la interfaz");
        }
    }

    private List<Correo> getAllCorreo() {
        return Arrays.asList(
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente", getRandomColor()),
                new Correo ("rrhh@miempresa.com", "Oferta de empleo", "Mi empresa SL ha visto su Curriculum Vitae y desea tener una entrevista de trabajo con usted para el día 25/11/18. Deseamos tenerte en nuestra plantilla de trabajo.", getRandomColor()),
                new Correo ("jefatura@iesfernandoaguilar.com", "Tienes un apercibimiento", "Tu conducta no está siendo la más correcta, por lo que has sido sancionado.", getRandomColor()),
                new Correo ("nicolas@mailapp.com", "Nicolas Corchero Montero en vivo!", "Has comprado una entrada para ver a Nicolas Corchero Montero el día 16 de Diciembre.", getRandomColor()),
                new Correo ("mara@iesfernandoaguilar.com", "Aprobados en Acceso a datos", "La siguiente lista muestra todos los aprobados en el primer examen de AD, cualquier alumno que no aparezca significa que está suspenso:\n\nPuedes venir durante la tutoría para ver el examen y responder a dudas.", getRandomColor()),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente", getRandomColor()),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente", getRandomColor()),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente", getRandomColor()),
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente", getRandomColor())

        );
    }

    private int getRandomColor() {
        return colores.get((int)(Math.random()*colores.size()));
    }

    private List<Integer> getAllColor() {
        return Arrays.asList(
                R.color.color_random0,
                R.color.color_random1,
                R.color.color_random2,
                R.color.color_random3,
                R.color.color_random4,
                R.color.color_random5,
                R.color.color_random6,
                R.color.color_random7,
                R.color.color_random8,
                R.color.color_random9
        );
    }

    public interface OnNameSent {
        void onChange (Correo correo);
    }

}
