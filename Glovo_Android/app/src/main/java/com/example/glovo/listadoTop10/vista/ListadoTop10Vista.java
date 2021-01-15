package com.example.glovo.listadoTop10.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;
import com.example.glovo.listadoTop10.presenter.ListadoTop10Presenter;

import java.util.ArrayList;

public class ListadoTop10Vista extends AppCompatActivity implements ListadoTop10Contrato.Vista {

    private ListadoTop10Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_top10_recycler);

        presenter = new ListadoTop10Presenter(this);
        presenter.getTop10();

    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantesTop10) {

    }

    @Override
    public void listadoError(String error) {

    }
}