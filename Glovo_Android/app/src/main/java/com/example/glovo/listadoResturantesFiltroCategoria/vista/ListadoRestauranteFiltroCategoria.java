package com.example.glovo.listadoResturantesFiltroCategoria.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.glovo.R;

public class ListadoRestauranteFiltroCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_filtrados_categoria);

        Intent datos = this.getIntent();
        Bundle extra = datos.getExtras();

        String idCategoria = String.valueOf(extra.getInt("idCategoria"));
        Toast.makeText(getBaseContext(), idCategoria, Toast.LENGTH_LONG).show();
    }
}