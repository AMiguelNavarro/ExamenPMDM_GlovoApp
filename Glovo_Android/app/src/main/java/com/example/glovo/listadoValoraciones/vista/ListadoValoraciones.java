package com.example.glovo.listadoValoraciones.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.adapters.ValoracionesAdapter;
import com.example.glovo.beans.Valoracion;
import com.example.glovo.listadoValoraciones.interfaces.ListadoValoracionesContrato;
import com.example.glovo.listadoValoraciones.presenter.ListadoValoracionesPresenter;

import java.util.ArrayList;

public class ListadoValoraciones extends AppCompatActivity implements ListadoValoracionesContrato.Vista {

    private ListadoValoracionesPresenter presenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;


    // SQL saca nombre y puntuación media: select restaurantes.nombre, AVG(valoraciones.puntuacion) as puntuacion, restaurantes.imagen from valoraciones INNER JOIN restaurantes on restaurantes.idRestaurante = valoraciones.idRestaurante GROUP BY restaurantes.nombre
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.valoraciones_listado_recycler);

        presenter = new ListadoValoracionesPresenter(this);
        presenter.getValoraciones();

    }


    @Override
    public void listadoCorrecto(ArrayList<Valoracion> listaValoraciones) {

        recycler = findViewById(R.id.recyclerValoraciones);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        // TODO instanciar adapter

    }

    @Override
    public void listadoError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}