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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.glovo.beans.Categoria;
import com.example.glovo.beans.Usuario;
import com.example.glovo.listadoCategorias.ListadoCategoriasContrato;
import com.example.glovo.listadoCategorias.ListadoCategoriasPresenter;
import com.example.glovo.listadoRestaurantes.vista.FragmentRestaurantesInicio;
import com.example.glovo.listadoResturantesFiltroCategoria.vista.FragmentRestaurantesFiltroCategoria;
import com.example.glovo.listadoTop10.vista.FragmentRestaurantesTop10;
import com.example.glovo.listadoValoraciones.vista.FragmentValoraciones;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements ListadoCategoriasContrato.Vista {

    private RelativeLayout layout;
    private String[] opcionesSpinner;
    private TextView tvNombreUsuario;
    private Usuario usuario = new Usuario();
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private ListadoCategoriasPresenter presenter;
    private AutoCompleteTextView autoCompleteTextViewDropdownMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Intent navegar = this.getIntent();
        Bundle extra = navegar.getExtras();
        usuario.setIdUsuario(extra.getInt("idUsuario"));
        usuario.setUsuario(extra.getString("usuario"));

        initComponents();

        tvNombreUsuario.setText(usuario.getUsuario());

        presenter = new ListadoCategoriasPresenter(this);
        presenter.getCategorias(this);

        bottomNavigationView.setSelectedItemId(R.id.menu_nav1);
        iniciarBottomNavigationView();

        fragmentManager = getSupportFragmentManager();

        showFragmentInicio();

    }

    private void initComponents() {
        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario);
        layout = findViewById(R.id.layout_listado_restaurantes_vista);
        bottomNavigationView = findViewById(R.id.bottom_navigation_inicio);
        autoCompleteTextViewDropdownMenu = findViewById(R.id.autoComplete_textView_dropdownMenu);
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
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentValoraciones fragmentValoraciones = new FragmentValoraciones();
        transaction.replace(R.id.linear_layout_fragments, fragmentValoraciones);
        transaction.addToBackStack(null); // Para volver al fragment anterior
        transaction.commit();
    }

    private void showFragmentFiltroCategoria(String categoria) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentRestaurantesFiltroCategoria fragmentRestaurantesFiltroCategoria = FragmentRestaurantesFiltroCategoria.newInstance(categoria);
        transaction.replace(R.id.linear_layout_fragments, fragmentRestaurantesFiltroCategoria);
        transaction.addToBackStack(null); // Para volver al fragment anterior
        transaction.commit();
    }

    @Override
    public void listadoCategoriasCorrecto(ArrayList<Categoria> listaCategorias) {
        cargarSpinner(listaCategorias);
    }

    @Override
    public void listadoCategoriasError(String error) {
        crearSnackbar("No se puede cargar el spinner con las categorias");
    }



    public void cargarSpinner(ArrayList<Categoria> listaCategorias) {
        opcionesSpinner = new String[listaCategorias.size()];

        for (int i = 0; i < listaCategorias.size(); i++) {
            Categoria categoria = listaCategorias.get(i);
            opcionesSpinner[i] = categoria.getCategoria();
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.dropdown_menu_item_layout, opcionesSpinner);
        autoCompleteTextViewDropdownMenu.setAdapter(arrayAdapter);
        autoCompleteTextViewDropdownMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categoria = parent.getItemAtPosition(position).toString();
                showFragmentFiltroCategoria(categoria);
            }
        });


    }


    private void crearSnackbar(String mensaje) {
        Snackbar snackbar = Snackbar.make(layout, mensaje, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


}