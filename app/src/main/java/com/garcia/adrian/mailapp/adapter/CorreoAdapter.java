package com.garcia.adrian.mailapp.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.garcia.adrian.mailapp.R;
import com.garcia.adrian.mailapp.activities.MainActivity;
import com.garcia.adrian.mailapp.model.Correo;

import java.util.List;

public class CorreoAdapter extends RecyclerView.Adapter<CorreoAdapter.ViewHolder> {

    private List<Correo> correos;
    private int layout;
    private Activity activity;
    private OnItemClickListener listener;

    private ViewGroup viewGroup;

    public CorreoAdapter (List<Correo> correos, int layout, Activity activity, OnItemClickListener listener) {
        this.correos = correos;
        this.layout = layout;
        this.activity = activity;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CorreoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(activity).inflate(layout,viewGroup, false);
        ViewHolder viewHolder= new ViewHolder(view);

        this.viewGroup = viewGroup;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CorreoAdapter.ViewHolder viewHolder, final int i) {

        final Correo correo = correos.get(i);

        viewHolder.textViewCaracter.setText(correo.getCaracter());
        viewHolder.textViewTitulo.setText(correo.getTituloResumen());
        viewHolder.textViewCuerpo.setText(correo.getCuerpoResumen());

        // Cambiamos el color de los circulitos!!
        Drawable background = viewHolder.textViewCaracter.getBackground();
        GradientDrawable shapeDrawable = (GradientDrawable) background;
        shapeDrawable.setColor(ContextCompat.getColor(viewGroup.getContext(), correo.getColor()));

        viewHolder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(correo, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return correos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linear;
        TextView textViewCaracter;
        TextView textViewTitulo;
        TextView textViewCuerpo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCaracter= itemView.findViewById(R.id.textFieldCaracter);
            textViewTitulo= itemView.findViewById(R.id.textViewTitulo);
            textViewCuerpo= itemView.findViewById(R.id.textViewCuerpo);

            linear = itemView.findViewById(R.id.id_correo);
        }


    }

    public interface OnItemClickListener{
        void onItemClick(Correo correo, int posicion);
    }
}