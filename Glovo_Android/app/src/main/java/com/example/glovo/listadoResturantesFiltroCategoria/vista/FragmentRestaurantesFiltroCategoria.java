package com.example.glovo.listadoResturantesFiltroCategoria.vista;

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
import com.example.glovo.listadoResturantesFiltroCategoria.interfaces.LstRestaurantesCategoriaContrato;
import com.example.glovo.listadoResturantesFiltroCategoria.presenter.LstRestaurantesCategoriaPresenter;
import com.example.glovo.listadoTop10.presenter.ListadoTop10Presenter;

import java.util.ArrayList;

public class FragmentRestaurantesFiltroCategoria extends Fragment implements LstRestaurantesCategoriaContrato.Vista {

    private LstRestaurantesCategoriaPresenter presenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;

    public static final String ARG_EXTRA_CATEGORIA = "categoria";

    private String categoria;


    public static FragmentRestaurantesFiltroCategoria newInstance(String categoria) {
        FragmentRestaurantesFiltroCategoria fragment = new FragmentRestaurantesFiltroCategoria();
        Bundle args = new Bundle();
        args.putString(ARG_EXTRA_CATEGORIA, categoria);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoria = getArguments().getString(ARG_EXTRA_CATEGORIA);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_filtro_categoria_restaurantes, container, false);
        initComponents(vista);

        // Instanciar al presenter
        presenter = new LstRestaurantesCategoriaPresenter(this);
        presenter.getRestaurantesCategoria(vista.getContext(), categoria);

        return vista;
    }

    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_filtro_categoria);
    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes) {
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
