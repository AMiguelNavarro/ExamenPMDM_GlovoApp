package com.example.glovo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.glovo.beans.Usuario;
import com.example.glovo.listadoRestaurantes.vista.FragmentRestaurantesInicio;
import com.example.glovo.listadoResturantesFiltroCategoria.vista.LstRestaurantesCategoria;
import com.example.glovo.listadoTop10.vista.FragmentRestaurantesTop10;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private Spinner spinner;
    private String[] opcionesSpinner = {" ", "VER TODAS", "Fast Food", "Americana", "China", "Japonesa"};
    private Button btnVentas, btnPuntuacion;
    private Usuario usuario = new Usuario();
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_restaurantes);

        Intent navegar = this.getIntent();
        Bundle extra = navegar.getExtras();
        usuario.setIdUsuario(extra.getInt("idUsuario"));
        usuario.setNombre(extra.getString("usuario"));
        // DATOS DE USUARIO CORRECTOS

//        cargarBotones();
        cargarSpinner();
        layout = findViewById(R.id.layout_listado_restaurantes_vista);

        bottomNavigationView = findViewById(R.id.bottom_navigation_inicio);
        bottomNavigationView.setSelectedItemId(R.id.menu_nav1);
        iniciarBottomNavigationView();

        fragmentManager = getSupportFragmentManager();

        showFragmentInicio();

    }

    private void iniciarBottomNavigationView() {

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_nav1:
                        showFragmentInicio();
                        return true;

                    case R.id.menu_nav2:
                        showFragmentTop10();
                        return true;

                    case R.id.menu_nav3:
                        showFragmentValoraciones();
                        return true;
                }

                return false;
            }
        });

    }

    private void showFragmentInicio() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentRestaurantesInicio fragmentRestaurantesInicio = new FragmentRestaurantesInicio();
        transaction.replace(R.id.linear_layout_fragments, fragmentRestaurantesInicio);
        transaction.addToBackStack(null); // Para volver al fragment anterior
        transaction.commit();
    }

    private void showFragmentTop10() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentRestaurantesTop10 fragmentRestaurantesTop10 = new FragmentRestaurantesTop10();
        transaction.replace(R.id.linear_layout_fragments, fragmentRestaurantesTop10);
        transaction.addToBackStack(null); // Para volver al fragment anterior
        transaction.commit();
    }


    private void showFragmentValoraciones() {

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
                    navegar = new Intent(getBaseContext(), HomeActivity.class);
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



    private void crearSnackbar(String mensaje) {
        Snackbar snackbar = Snackbar.make(layout, mensaje, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}