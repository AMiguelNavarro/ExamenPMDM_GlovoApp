package com.example.glovo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovo.R;
import com.example.glovo.beans.Menu;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MenusViewHolder>{

    public ArrayList<Menu> listaMenus;

    public MenusAdapter(ArrayList<Menu> listaMenus) {
        this.listaMenus = listaMenus;
    }

    @NonNull
    @Override
    public MenusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout_vista_menu, parent, false);
        return new MenusViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MenusViewHolder holder, int position) {

        Menu menu = listaMenus.get(position);

        holder.nombreMenu.setText(menu.getNombreMenu());
        holder.precioMenu.setText(menu.getPrecio() + " €/unidad");
        holder.primero.setText("● " + menu.getPrimero());
        holder.segundo.setText("● " + menu.getSegundo());
        holder.postre.setText("● " + menu.getPostre());
        holder.bebida.setText("● " + menu.getBebida());
        holder.cantidadContador.setText("1");
        Picasso.get().load(menu.getImagenMenu()).fit().centerCrop().into(holder.imagenMenu);

        int numero = Integer.parseInt((String) holder.cantidadContador.getText());
        final int[] contador = {numero};

        holder.botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador[0]++;
                holder.cantidadContador.setText(String.valueOf(contador[0]));
            }
        });

        holder.botonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador[0]--;
                if (contador[0] < 1) {
                    contador[0] = 1;
                }
                holder.cantidadContador.setText(String.valueOf(contador[0]));
            }
        });

        holder.botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt(String.valueOf(holder.cantidadContador.getText()));
                double precio = menu.getPrecio();
                double resultado = cantidad * precio;
                Snackbar snackbar = Snackbar.make(holder.layout, "Compra realizada: " + cantidad + " unidades TOTAL -> " + resultado + " €", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return listaMenus.size();
    }

    public static class MenusViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagenMenu;
        public TextView nombreMenu, precioMenu, primero, segundo, postre, bebida, cantidadTexto,
        cantidadContador;
        public MaterialButton botonSumar, botonRestar, botonComprar;
        public LinearLayout layout;

        public MenusViewHolder(@NonNull View v) {
            super(v);
            imagenMenu = v.findViewById(R.id.imagenMenu);
            nombreMenu = v.findViewById(R.id.nombreMenu);
            precioMenu = v.findViewById(R.id.precioMenu);
            primero = v.findViewById(R.id.primeroMenu);
            segundo = v.findViewById(R.id.segundoMenu);
            postre = v.findViewById(R.id.postreMenu);
            bebida = v.findViewById(R.id.bebidaMenu);
            cantidadTexto = v.findViewById(R.id.tvcantidad_texto);
            cantidadContador = v.findViewById(R.id.tvcantidad_contador);
            botonSumar = v.findViewById(R.id.button_sumar);
            botonRestar = v.findViewById(R.id.button_restar);
            botonComprar = v.findViewById(R.id.button_comprar);
            layout = v.findViewById(R.id.layout_cardView_menu);
        }
    }

}
