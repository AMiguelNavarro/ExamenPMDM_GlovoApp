package com.example.glovo.listadoValoraciones.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listado_valoraciones, container, false);
        initComponents(vista);

        // Instanciar al presenter
        presenter = new ListadoValoracionesPresenter(this);
        presenter.getValoraciones(getContext());

        return vista;
    }


    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_valoraciones);
    }

    @Override
    public void listadoCorrecto(ArrayList<Valoracion> listaValoraciones) {
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        ValoracionesAdapter adapter = new ValoracionesAdapter(listaValoraciones);
        recycler.setAdapter(adapter);
    }

    @Override
    public void listadoError(String error) {
        System.out.println(error);
    }
}
