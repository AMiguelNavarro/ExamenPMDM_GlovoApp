package com.example.glovo.listadoTop10.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;

import java.util.ArrayList;

public class listadoTop10Vista extends AppCompatActivity implements ListadoTop10Contrato.Vista {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_top10_recycler);

        // TODO estructura mvp con consulta a la bd
    }

    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantesTop10) {

    }

    @Override
    public void listadoError(String error) {

    }
}