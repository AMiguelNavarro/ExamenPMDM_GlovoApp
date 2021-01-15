package com.example.glovo.listadoResturantesFiltroCategoria.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.adapters.RestaurantesAdapter;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.vista.ListadoRestaurantes;
import com.example.glovo.listadoResturantesFiltroCategoria.interfaces.LstRestaurantesCategoriaContrato;
import com.example.glovo.listadoResturantesFiltroCategoria.presenter.LstRestaurantesCategoriaPresenter;

import java.util.ArrayList;

public class LstRestaurantesCategoria extends AppCompatActivity implements LstRestaurantesCategoriaContrato.Vista {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private LstRestaurantesCategoriaPresenter presenterCategoria;
    private Spinner spinner;
    private String[] opcionesSpinner = {" ", "VER TODAS", "Fast Food", "Americana", "China", "Japonesa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_filtrados_categoria);

        Intent datos = this.getIntent();
        Bundle extra = datos.getExtras();

        String categoria = String.valueOf(extra.getString("categoria"));
        Toast.makeText(getBaseContext(), categoria, Toast.LENGTH_LONG).show(); // CORRECTO

        presenterCategoria = new LstRestaurantesCategoriaPresenter(this);
        presenterCategoria.getRestaurantesCategoria(categoria);

        cargarSpinner();
    }


    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes) {

        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        RestaurantesAdapter adapter = new RestaurantesAdapter(listaRestaurantes);
        recycler.setAdapter(adapter);

    }

    @Override
    public void listadoError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    public void cargarSpinner() {

        spinner = findViewById(R.id.spinnerFiltro);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesSpinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelected(false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Intent navegar;
                String categoria = parent.getItemAtPosition(position).toString();

                if (categoria == " ") {
                    return;
                }

                if (categoria == "VER TODAS") {
                    navegar = new Intent(getBaseContext(), ListadoRestaurantes.class);
                    startActivity(navegar);
                    return;
                }

                navegar = new Intent(getBaseContext(), LstRestaurantesCategoria.class);
                navegar.putExtra("categoria", categoria);

                startActivity(navegar);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "No has seleccionado nada", Toast.LENGTH_LONG).show();
            }
        });


    }


}