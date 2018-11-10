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
    private OnMailSent callback;

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
            callback = (OnMailSent) context;
        }catch (ClassCastException e){
            System.out.println("Error: deberia implementar la interfaz");
        }
    }

    private List<Correo> getAllCorreo() {
        return Arrays.asList(
                new Correo ("admin@mailapp.com", "Bienvenidos a MailApp", "Si estas leyendo esto es que la aplicación está funcionando correctamente", getRandomColor()),
                new Correo ("rrhh@miempresa.com", "Oferta de empleo", "Mi empresa SL ha visto su Curriculum Vitae y desea tener una entrevista de trabajo con usted para el día 25/11/18. Deseamos tenerte en nuestra plantilla de trabajo.", getRandomColor()),
                new Correo ("jefatura@iesfernandoaguilar.com", "Tienes un apercibimiento", "Tu conducta no está siendo la más correcta, por lo que has sido sancionado.", getRandomColor()),
                new Correo ("nicolas@mailapp.com", "Nicolas Corchero Montero en vivo!", "Has comprado una entrada para ver el concierto en vivo \"GRACIAS\", de Nicolas Corchero Montero el día 16 de Diciembre. Ponle música a la fe!", getRandomColor()),
                new Correo ("mara@iesfernandoaguilar.com", "Aprobados en Acceso a datos", "La siguiente lista muestra todos los aprobados en el primer examen de AD, cualquier alumno que no aparezca significa que está suspenso:\n\n\n\n\n\nPuedes venir durante la tutoría para ver el examen y responder a dudas.", getRandomColor()),
                new Correo ("info@linkedin.com", "¡Has aparecido en 7 búsquedas esta semana!", "Tu no serás acaso un influencer de las redes sociales o algo así, no?", getRandomColor()),
                new Correo ("jefatura@iesfernandoaguilar.com", "VOTACIONES DE LOS PADRES Y MADRES CONSEJO ESCOLAR. PUEDEN DAR EL VOTO A SUS HIJOS/AS.", "Estimadas familias. El próximo martes 13 de Noviembre desde las 16.30h hasta las 21.30h podrán depositar su voto para elegir a los representantes deL SECTOR de padres y madres en el consejo Escolar. La Mesa estará disponible en el AMPA.\n\n\nTambién podrán hacer entrega del voto en dirección durante los cinco días anteriores al de la votación, incluso sus hijos/as pueden hacer entrega del voto mediante el sistema de doble sobre. ", getRandomColor()),
                new Correo ("tecreamostuapp@gmail.com", "Creamos los fragments por ti", "Que ningún fragment te amargue el fin de semana!! Nosotros te lo hacemos por ti por solo 50€. Y por 20€ más te arreglamos todos los problemas que tengas con el Gradle.", getRandomColor()),
                new Correo ("notmundotoday@trustme.com", "Todos los científicos del mundo, humillados al comprobar que se empiezan a notar ya los efectos de la homeopatía", "A pesar de la campaña de descrédito y deslegitimación promovida desde el ámbito de la ciencia, los hechos se han acabado imponiendo y finalmente, tras años de insistencia, los efectos curativos de la homeopatía se han empezado a notar de golpe en todos los rincones del mundo en los que se estaba aplicando esta denominada pseudociencia.", getRandomColor())

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

    public interface OnMailSent {
        void onChange (Correo correo);
    }

}
