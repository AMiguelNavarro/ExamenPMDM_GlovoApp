package com.example.glovo.listadoTop10.vista;

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
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;
import com.example.glovo.listadoTop10.presenter.ListadoTop10Presenter;

import java.util.ArrayList;

public class FragmentRestaurantesTop10 extends Fragment implements ListadoTop10Contrato.Vista {

    private ListadoTop10Presenter presenter;
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
        View vista = inflater.inflate(R.layout.fragment_listado_restaurantes_top10, container, false);
        initComponents(vista);

        // Instanciar al presenter
        presenter = new ListadoTop10Presenter(this);
        presenter.getTop10(getContext());

        pbProgreso.setVisibility(View.VISIBLE);

        btError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getTop10(getContext());
                pbProgreso.setVisibility(View.VISIBLE);
                layoutError.setVisibility(View.GONE);
            }
        });

        return vista;
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


    private void initComponents(View vista) {
        pbProgreso = vista.findViewById(R.id.fragment_restaurantes_top10_progressBar);
        layoutError = vista.findViewById(R.id.fragment_restaurantes_top10_linearLayout_error);
        tvError = vista.findViewById(R.id.fragment_restaurantes_top10_tv_error);
        btError = vista.findViewById(R.id.fragment_restaurantes_top10_button_retry);
        recycler = vista.findViewById(R.id.recycler_top10);
    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantesTop10) {
        ocultarError();

        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        RestaurantesAdapter adapter = new RestaurantesAdapter(listaRestaurantesTop10);
        recycler.setAdapter(adapter);

    }

    @Override
    public void listadoError(String error) {
        mostrarError(error);
        System.out.println(error);
    }
}
