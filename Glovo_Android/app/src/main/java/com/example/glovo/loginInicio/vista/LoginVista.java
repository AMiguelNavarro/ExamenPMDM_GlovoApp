package com.example.glovo.loginInicio.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.beans.Usuario;
import com.example.glovo.listadoRestaurantes.vista.ListadoRestaurantes;
import com.example.glovo.loginInicio.interfaces.LoginInterfazContrato;
import com.example.glovo.loginInicio.presenter.LoginPresenter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class LoginVista extends AppCompatActivity implements LoginInterfazContrato.Vista {

    private TextInputEditText usuario;
    private TextInputEditText contrasena;
    private LinearLayout layout;
    private Button btInicioSesion;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vista);

        iniciarComponentes();

        presenter = new LoginPresenter(this);

    }

    private void iniciarComponentes() {
        usuario = findViewById(R.id.usuario_et);
        contrasena = findViewById(R.id.contrasena_et);
        btInicioSesion = findViewById(R.id.btInicioSesion);
        layout = findViewById(R.id.layout_login_vista);
    }

    public void validarUsuario(View v){

        String usuario = String.valueOf(this.usuario.getText());
        String contrasena = String.valueOf(this.contrasena.getText());

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            crearSnackbar("Debes rellenar los campos 'usuario' y 'contraseña' para acceder a la APP");
            this.usuario.setError("Error de usuario");
            this.contrasena.setError("Error de contraseña");
        } else {
            presenter.validarUsuario(this, usuario, contrasena);
        }

    }


    @Override
    public void usuarioCorrecto(Usuario datosUsuario) {

            Intent navegar = new Intent(getBaseContext(), ListadoRestaurantes.class);
            navegar.putExtra("idUsuario", datosUsuario.getIdUsuario());
            navegar.putExtra("usuario", datosUsuario.getUsuario());
            startActivity(navegar);

    }

    @Override
    public void usuarioIncorrecto(String error) {
        crearSnackbar(error);
        this.usuario.setError("Error de usuario");
        this.contrasena.setError("Error de contraseña");
    }


    private void crearSnackbar(String mensaje) {
        Snackbar snackbar = Snackbar.make(layout, mensaje, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}