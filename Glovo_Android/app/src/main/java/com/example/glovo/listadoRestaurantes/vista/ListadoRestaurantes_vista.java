package com.example.glovo.listadoRestaurantes.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.listadoRestaurantes.presenter.ListadoRestaurantesPresenter;

import java.util.ArrayList;

public class ListadoRestaurantes_vista extends AppCompatActivity implements ListadoRestaurantesContrato.Vista {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ListadoRestaurantesPresenter listadoRestaurantesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_restaurantes);

        // Instanciar al presenter
        listadoRestaurantesPresenter = new ListadoRestaurantesPresenter( this);
        listadoRestaurantesPresenter.getRestaurantes();

        // coger el recycler y fijar tamaño
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

//        adapter = new RestaurantesAdapter(listaRestaurantes); TODO adapter con la lista de los restaurantes traida del servletl
//        recycler.setAdapter(adapter);

    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes) {

    }

    @Override
    public void listadoError(String error) {

    }
}