package com.garcia.adrian.mailapp.fragments;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.activities.MainActivity;
import com.garcia.adrian.mailapp.model.Correo;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContenido extends Fragment {

    private LinearLayout linear;
    private TextView textoTitulo;
    private TextView textoFrom;
    private TextView textoCuerpo;

    public FragmentContenido() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_contenido, container, false);

        linear = view.findViewById(R.id.fragmentContenidoTodo);
        textoTitulo = view.findViewById(R.id.fragmentTitulo);

        textoFrom = view.findViewById(R.id.fragmentFrom);
        textoCuerpo = view.findViewById(R.id.fragmentContenido);

        Log.e("INFO_SOBRE_FRAGMENT", "HA ENTRADO");
        Log.e("INFO_SOBRE_FRAGMENT", textoCuerpo.getText().toString());

        return view;
    }

    public void onCorreoChange (Correo correo) {
        linear.setVisibility(View.VISIBLE);
        textoTitulo.setText(correo.getTitulo());
        textoFrom.setText(correo.getSujeto());
        textoCuerpo.setText(correo.getCuerpo());
    }

    public void onCorreoChange (String titulo, String sujeto, String cuerpo) {
        //linear.setVisibility(View.VISIBLE);
        textoTitulo.setText(titulo);
        textoFrom.setText(sujeto);
        textoCuerpo.setText(cuerpo);
    }
}