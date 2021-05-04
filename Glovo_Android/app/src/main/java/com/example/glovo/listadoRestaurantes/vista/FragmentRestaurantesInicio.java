package com.example.glovo.listadoRestaurantes.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glovo.R;
import com.example.glovo.adapters.RestaurantesAdapter;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.listadoRestaurantes.presenter.ListadoRestaurantesPresenter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FragmentRestaurantesInicio extends Fragment implements ListadoRestaurantesContrato.Vista {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private ListadoRestaurantesPresenter listadoRestaurantesPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listado_general_restaurantes_recycler, container, false);
        initComponents(vista);

        // Instanciar al presenter
        listadoRestaurantesPresenter = new ListadoRestaurantesPresenter(this);
        listadoRestaurantesPresenter.getRestaurantes(getContext());

        return vista;
    }

    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_inicio);
    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes) {
        // coger el recycler y fijar tamaño

        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        RestaurantesAdapter adapter = new RestaurantesAdapter(listaRestaurantes);
        recycler.setAdapter(adapter);
    }

    @Override
    public void listadoError(String error) {
        System.out.println(error);
    }



}
