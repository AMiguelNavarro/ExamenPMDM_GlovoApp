package com.example.glovo.listadoTop10.vista;

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
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;
import com.example.glovo.listadoTop10.presenter.ListadoTop10Presenter;

import java.util.ArrayList;

public class FragmentRestaurantesTop10 extends Fragment implements ListadoTop10Contrato.Vista {

    private ListadoTop10Presenter presenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listado_restaurantes_top10, container, false);
        initComponents(vista);

        // Instanciar al presenter
        presenter = new ListadoTop10Presenter(this);
        presenter.getTop10(getContext());

        return vista;
    }


    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_top10);
    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantesTop10) {

        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        RestaurantesAdapter adapter = new RestaurantesAdapter(listaRestaurantesTop10);
        recycler.setAdapter(adapter);

    }

    @Override
    public void listadoError(String error) {
        System.out.println(error);
    }
}
