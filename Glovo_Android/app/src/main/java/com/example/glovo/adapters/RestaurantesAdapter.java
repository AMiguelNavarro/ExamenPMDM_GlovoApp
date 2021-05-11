package com.example.glovo.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovo.FichaDescriptiva.FichaDescriptivaVista;
import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantesAdapter extends RecyclerView.Adapter<RestaurantesAdapter.RestaurantesViewHolder> {

    public ArrayList<Restaurante> listaRestaurantes;

    /**
     * Constructor del adapter. Inicializa el arrayList que nos viene de la base de datos
     *
     * @param listaRestaurante
     */
    public RestaurantesAdapter(ArrayList<Restaurante> listaRestaurante) {
        this.listaRestaurantes = listaRestaurante;
    }

    /**
     * Crea la vista de cada tarjeta con el método inflate a partir de layout parent
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RestaurantesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_restaurantes, parent, false);

        return new RestaurantesViewHolder(vista);

    }


    /**
     * Añade los valores de la lista de restaurantes que viene en el arrayList
     *
     * @param holder
     * @param position posición de la fila
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RestaurantesViewHolder holder, int position) {

        Restaurante restaurante = listaRestaurantes.get(position);

        holder.nombre.setText(restaurante.getNombre());
        holder.descripcion.setText(restaurante.getDescripcion());
        holder.numVentas.setText("Num ventas: " + restaurante.getNumVentas());
        Picasso.get().load(restaurante.getImagen()).into(holder.imagen);

        // Animación imágenes
        AlphaAnimation animation1 = new AlphaAnimation(0.2f, 1.0f);
        animation1.setDuration(1100);
        animation1.setStartOffset(500);
        animation1.setFillAfter(true);
        holder.imagen.startAnimation(animation1);

        /**
         * Coge los datos del elemento pulsado y los manda a la vista de la ficha descriptiva
         */
        holder.itemView.setOnClickListener(v -> {

            Intent navegar = new Intent(v.getContext(), FichaDescriptivaVista.class);

            navegar.putExtra("nombre", restaurante.getNombre());
            navegar.putExtra("descripcion", restaurante.getDescripcion());
            navegar.putExtra("imagen", restaurante.getImagen());
            navegar.putExtra("idRestaurante", restaurante.getIdRestaurante());

            v.getContext().startActivity(navegar);

        });


    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }


    public static class RestaurantesViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre, descripcion, numVentas;
        public FloatingActionButton botonAnadirRestaurante;

        /**
         * Constructor del viewHolder. Carga los datos del card view que se iran modificando
         *
         * @param v
         */
        public RestaurantesViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenValoracion);
            nombre = v.findViewById(R.id.nombreValoracion);
            descripcion = v.findViewById(R.id.descripcionValoracion);
            numVentas = v.findViewById(R.id.numVentas);
        }
    }

}
