package com.example.glovo.listadoValoraciones.vista;

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
import com.example.glovo.adapters.ValoracionesAdapter;
import com.example.glovo.beans.Valoracion;
import com.example.glovo.listadoValoraciones.interfaces.ListadoValoracionesContrato;
import com.example.glovo.listadoValoraciones.presenter.ListadoValoracionesPresenter;

import java.util.ArrayList;

public class FragmentValoraciones extends Fragment implements ListadoValoracionesContrato.Vista {

    private ListadoValoracionesPresenter presenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar pbProgreso;
    private LinearLayout layoutError;
    private TextView tvError;
    private Button btError;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listado_valoraciones, container, false);
        initComponents(vista);

        // Instanciar al presenter
        presenter = new ListadoValoracionesPresenter(this);
        presenter.getValoraciones(getContext());

        pbProgreso.setVisibility(View.VISIBLE);

        btError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getValoraciones(getContext());
                pbProgreso.setVisibility(View.VISIBLE);
                layoutError.setVisibility(View.GONE);
            }
        });

        return vista;
    }


    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_valoraciones);
        pbProgreso = vista.findViewById(R.id.fragment_restaurantes_valoraciones_progressBar);
        layoutError = vista.findViewById(R.id.fragment_restaurantes_valoraciones_linearLayout_error);
        tvError = vista.findViewById(R.id.fragment_restaurantes_valoraciones_tv_error);
        btError = vista.findViewById(R.id.fragment_restaurantes_valoraciones_button_retry);
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
    public void listadoCorrecto(ArrayList<Valoracion> listaValoraciones) {

        ocultarError();
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        ValoracionesAdapter adapter = new ValoracionesAdapter(listaValoraciones);
        recycler.setAdapter(adapter);
    }

    @Override
    public void listadoError(String error) {
        mostrarError(error);
        System.out.println(error);
    }
}
