package com.example.glovo.listadoMenus.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.adapters.MenusAdapter;
import com.example.glovo.beans.Menu;
import com.example.glovo.listadoMenus.interfaces.ListadoMenusContrato;
import com.example.glovo.listadoMenus.presenter.ListadoMenusPresenter;

import java.util.ArrayList;

public class ListadoMenusVista extends AppCompatActivity implements ListadoMenusContrato.Vista {

    private int idRestaurante;
    private ListadoMenusPresenter presenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_listado_menus);

        Intent recogerDatos = getIntent();
        idRestaurante = recogerDatos.getIntExtra("idRestaurante", 0);

        presenter = new ListadoMenusPresenter(this);
        presenter.getMenus(idRestaurante);

    }

    @Override
    public void listadoCorrecto(ArrayList<Menu> listaMenus) {

        recycler = findViewById(R.id.recyclerMenus);
        recycler.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recycler.setLayoutManager(layoutManager);

        MenusAdapter adapter = new MenusAdapter(listaMenus);
        recycler.setAdapter(adapter);

    }

    @Override
    public void listadoError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}