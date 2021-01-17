package com.example.glovo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovo.R;
import com.example.glovo.beans.Menu;
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
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_lista_menus, parent, false);
        return new MenusViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MenusViewHolder holder, int position) {

        Menu menu = listaMenus.get(position);

        holder.nombreMenu.setText(menu.getNombreMenu());
        holder.precioMenu.setText(menu.getPrecio() + " €");
        Picasso.get().load(menu.getImagenMenu()).fit().centerCrop().into(holder.imagenMenu);

    }

    @Override
    public int getItemCount() {
        return listaMenus.size();
    }

    public static class MenusViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagenMenu;
        public TextView nombreMenu, precioMenu;

        public MenusViewHolder(@NonNull View v) {
            super(v);
            imagenMenu = v.findViewById(R.id.imagenMenu);
            nombreMenu = v.findViewById(R.id.nombreMenu);
            precioMenu = v.findViewById(R.id.precioMenu);
        }
    }

}
