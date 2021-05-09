package com.example.glovo.anadirRestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.glovo.R;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.RestauranteDTO;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class AnadirRestauranteVista extends AppCompatActivity implements AnadirRestauranteContrato.Vista{

    private AnadirRestaurantePresenter presenter;
    private MaterialButton botonAnadir;
    private TextInputEditText nombreRestaurante, descripcionRestaurante;
    private RadioGroup radioButtonGroup;
    private RelativeLayout layout;
    private AnadirRestauranteContrato.Vista vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_restaurante);

        initComponents();

        botonAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = String.valueOf(nombreRestaurante.getText());
                String descripcion = String.valueOf(descripcionRestaurante.getText());

                if (nombre.isEmpty() || descripcion.isEmpty()) {
                    crearSnackbar("Debes rellenar los campos de nombre y descripción");
                    nombreRestaurante.setError("Error de usuario");
                    descripcionRestaurante.setError("Error de contraseña");
                }

                RestauranteDTO restauranteDTO = new RestauranteDTO();
                restauranteDTO.setNombre(nombre);
                restauranteDTO.setDescripcion(descripcion);

                radioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton rb = findViewById(checkedId);
                        String categoria = rb.getText().toString();
                        restauranteDTO.setNombreCategoria(categoria);
                    }
                });

                presenter = new AnadirRestaurantePresenter(vista);
                presenter.addRestaurante(v.getContext(), restauranteDTO);

            }
        });


    }

//    private void funcionalidadBotonAnadir() {
//
//        String nombre = String.valueOf(nombreRestaurante.getText());
//        String descripcion = String.valueOf(descripcionRestaurante.getText());
//
//        if (nombre.isEmpty() || descripcion.isEmpty()) {
//            crearSnackbar("Debes rellenar los campos de nombre y descripción");
//            this.nombreRestaurante.setError("Error de usuario");
//            this.descripcionRestaurante.setError("Error de contraseña");
//        }
//
//        RestauranteDTO restauranteDTO = new RestauranteDTO();
//        restauranteDTO.setNombre(nombre);
//        restauranteDTO.setDescripcion(descripcion);
//
//        radioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton rb = findViewById(checkedId);
//                String categoria = rb.getText().toString();
//                restauranteDTO.setNombreCategoria(categoria);
//            }
//        });
//
//        presenter = new AnadirRestaurantePresenter(this);
//        presenter.addRestaurante(this, restauranteDTO);
//    }

    private void crearSnackbar(String mensaje) {
        Snackbar snackbar = Snackbar.make(layout, mensaje, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void initComponents() {
        botonAnadir = findViewById(R.id.boton_anadir);
        nombreRestaurante = findViewById(R.id.nombreRestaurante_et);
        descripcionRestaurante = findViewById(R.id.descripcion_et);
        radioButtonGroup = findViewById(R.id.radioGroup);
        layout = findViewById(R.id.anadir_restaurante_layout);
        vista = this;
    }

    @Override
    public void onAnadido(Restaurante nuevoRestaurante) {
        crearSnackbar("RESTAURANTE AÑADIDO CORRECTAMENTE");
    }

    @Override
    public void onError(String error) {
        crearSnackbar("OJO!!! Error al crear el restaurante");
    }
}