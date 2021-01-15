package com.example.glovo.listadoRestaurantes.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.adapters.RestaurantesAdapter;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.listadoRestaurantes.presenter.ListadoRestaurantesPresenter;
import com.example.glovo.listadoResturantesFiltroCategoria.vista.LstRestaurantesCategoria;
import com.example.glovo.listadoTop10.vista.ListadoTop10Vista;

import java.util.ArrayList;

public class ListadoRestaurantes extends AppCompatActivity implements ListadoRestaurantesContrato.Vista {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ListadoRestaurantesPresenter listadoRestaurantesPresenter;
    private Spinner spinner;
    private String [] opcionesSpinner = {" ","VER TODAS", "Fast Food", "Americana", "China","Japonesa"};
    private Button btnVentas, btnPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_restaurantes);

        // Instanciar al presenter
        listadoRestaurantesPresenter = new ListadoRestaurantesPresenter( this);
        listadoRestaurantesPresenter.getRestaurantes();

        cargarBotones();
        cargarSpinner();
    }




    @Override
    public void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes) {

        // coger el recycler y fijar tamaño
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

    public void getTop10(View v) {
        Intent navegar = new Intent(getBaseContext(), ListadoTop10Vista.class );
        startActivity(navegar);
    }

    public void getMayorPuntuacion(View v) {

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
                navegar.putExtra("categoria",categoria);

                startActivity(navegar);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getBaseContext(), "No has seleccionado nada", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void cargarBotones() {
        btnVentas = findViewById(R.id.btnVentas);
        btnPuntuacion = findViewById(R.id.btnPuntuacion);
    }

}