package com.example.glovo.listadoResturantesFiltroCategoria.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    private ProgressBar pbProgreso;
    private LinearLayout layoutError;
    private TextView tvError;
    private Button btError;

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

        pbProgreso.setVisibility(View.VISIBLE);

        btError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getRestaurantesCategoria(v.getContext(), categoria);
                pbProgreso.setVisibility(View.VISIBLE);
                layoutError.setVisibility(View.GONE);
            }
        });

        return vista;
    }

    private void initComponents(View vista) {
        pbProgreso = vista.findViewById(R.id.fragment_restaurantes_filtro_progressBar);
        layoutError = vista.findViewById(R.id.fragment_restaurantes_filtro_linearLayout_error);
        tvError = vista.findViewById(R.id.fragment_restaurantes_filtro_tv_error);
        btError = vista.findViewById(R.id.fragment_restaurantes_filtro_button_retry);
        recycler = vista.findViewById(R.id.recycler_filtro_categoria);
    }

    private void ocultarError(){
        pbProgreso.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);
    }

    private void mostrarError(String error){
        pbProgreso.setVisibility(View.GONE);
        recycler.setVisibility(View.GONE);
        layoutError.setVisibility(View.VISIBLE);
        tvError.setText(error);
    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes) {
        ocultarError();
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        RestaurantesAdapter adapter = new RestaurantesAdapter(listaRestaurantes);
        recycler.setAdapter(adapter);

    }

    @Override
    public void listadoError(String error) {
        mostrarError(error);
        System.out.println(error);
    }
}
