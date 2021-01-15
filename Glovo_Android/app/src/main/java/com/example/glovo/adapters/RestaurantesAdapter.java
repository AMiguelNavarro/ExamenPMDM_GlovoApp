package com.example.glovo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantesAdapter extends RecyclerView.Adapter<RestaurantesAdapter.RestaurantesViewHolder> {

    public ArrayList<Restaurante> listaRestaurantes;

    /**
     * Constructor del adapter. Inicializa el arrayList que nos viene de la base de datos
     * @param listaRestaurante
     */
    public RestaurantesAdapter(ArrayList<Restaurante> listaRestaurante) {
        this.listaRestaurantes = listaRestaurante;
    }

    /**
     * Crea la vista de cada tarjeta con el método inflate a partir de layout parent
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
     * @param holder
     * @param position posición de la fila
     */
    @Override
    public void onBindViewHolder(@NonNull RestaurantesViewHolder holder, int position) {

        Restaurante restaurante = listaRestaurantes.get(position);

        holder.nombre.setText(restaurante.getNombre());
        holder.descripcion.setText(restaurante.getDescripción());
        holder.numVentas.setText("Num Ventas: " + restaurante.getNumVentas());
        Picasso.get().load(restaurante.getImagen()).into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }


    public static class RestaurantesViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre, descripcion, numVentas;

        /**
         * Constructor del viewHolder. Carga los datos del card view que se iran modificando
         * @param v
         */
        public RestaurantesViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagen);
            nombre = v.findViewById(R.id.nombre);
            descripcion = v.findViewById(R.id.descripcion);
            numVentas = v.findViewById(R.id.numVentas);
        }
    }

}
