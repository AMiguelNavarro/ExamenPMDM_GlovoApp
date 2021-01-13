package com.example.glovo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.glovo.adapter.RestaurantesAdapter;
import com.example.glovo.beans.Restaurante;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // coger el recycler y fijar tamaño
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

//        adapter = new RestaurantesAdapter(listaRestaurantes); TODO adapter con la lista de los restaurantes traida del servlet
//        recycler.setAdapter(adapter);

    }
}