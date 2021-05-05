package com.example.glovo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.Valoracion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ValoracionesAdapter extends RecyclerView.Adapter<ValoracionesAdapter.ValoracionesViewHolder> {

    public ArrayList<Valoracion> listaValoraciones;

    public ValoracionesAdapter(ArrayList<Valoracion> listaValoraciones) {
        this.listaValoraciones = listaValoraciones;
    }


    @NonNull
    @Override
    public ValoracionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_valoraciones, parent, false);

        return new ValoracionesViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ValoracionesViewHolder holder, int position) {

        Valoracion valoracion = listaValoraciones.get(position);
        float estrellasValoracion = (float) valoracion.getPuntuacion();

        Restaurante restaurante = valoracion.getRestaurante();

        holder.nombre.setText(restaurante.getNombre());
        holder.ratingBar.setRating(estrellasValoracion);
        Picasso.get().load(restaurante.getImagen()).into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return listaValoraciones.size();
    }


    public static class ValoracionesViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre;
        public RatingBar ratingBar;

        public ValoracionesViewHolder(@NonNull View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenValoracion);
            nombre = v.findViewById(R.id.nombreValoracion);
            ratingBar = v.findViewById(R.id.ratingBar);
        }
    }
}
