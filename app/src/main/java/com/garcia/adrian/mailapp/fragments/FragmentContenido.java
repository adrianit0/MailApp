package com.garcia.adrian.mailapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.model.Correo;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContenido extends Fragment {

    private LinearLayout linear;
    private TextView textoTitulo;
    private TextView textoFrom;
    private TextView textoCuerpo;

    private OnMailSent callback;

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

        if (callback!=null)
            callback.onChange();

        return view;
    }

    public void onCorreoChange (Correo correo) {
        linear.setVisibility(View.VISIBLE);
        textoTitulo.setText(correo.getTitulo());
        textoFrom.setText(correo.getSujeto());
        textoCuerpo.setText(correo.getCuerpo());


    }

    public void onCorreoChange (String titulo, String sujeto, String cuerpo) {
        // Si no existe el contenido, no hay necesidad de mostrarlo por pantalla.
        if (linear==null)
            return;

        linear.setVisibility(View.VISIBLE);
        textoTitulo.setText(titulo);
        textoFrom.setText(sujeto);
        textoCuerpo.setText(cuerpo);
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

    public interface OnMailSent {
        void onChange ();
    }
}