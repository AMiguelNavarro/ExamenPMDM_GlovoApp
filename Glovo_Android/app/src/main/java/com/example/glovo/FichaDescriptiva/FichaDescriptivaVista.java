package com.example.glovo.FichaDescriptiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.listadoMenus.vista.ListadoMenusVista;
import com.squareup.picasso.Picasso;

public class FichaDescriptivaVista extends AppCompatActivity {

    private ImageView imagen;
    private TextView nombre, descripcion;
    private int idRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_descriptiva_vista);

        iniciarComponentes();

        Intent recogerDatos = getIntent();
        String imagen = recogerDatos.getStringExtra("imagen");
        String nombre = recogerDatos.getStringExtra("nombre");
        String descripcion = recogerDatos.getStringExtra("descripcion");
        this.idRestaurante = recogerDatos.getIntExtra("idRestaurante", 0);

        this.nombre.setText(nombre);
        this.descripcion.setText(descripcion);
        Picasso.get().load(imagen).into(this.imagen);

    }


    public void getListaMenus(View v) {
        Intent navegar = new Intent(v.getContext(), ListadoMenusVista.class);
        navegar.putExtra("idRestaurante", idRestaurante);

        startActivity(navegar);
    }


    public void iniciarComponentes() {
        imagen = findViewById(R.id.imagenFD);
        nombre = findViewById(R.id.nombreFD);
        descripcion = findViewById(R.id.descripcionFD);
    }
}