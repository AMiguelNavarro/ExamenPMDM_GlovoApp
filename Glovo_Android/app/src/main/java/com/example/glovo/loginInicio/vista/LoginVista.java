package com.example.glovo.loginInicio.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.glovo.R;
import com.example.glovo.beans.Usuario;
import com.example.glovo.listadoRestaurantes.vista.ListadoRestaurantes;
import com.example.glovo.loginInicio.interfaces.LoginInterfazContrato;
import com.example.glovo.loginInicio.presenter.LoginPresenter;

import java.util.ArrayList;

public class LoginVista extends AppCompatActivity implements LoginInterfazContrato.Vista {

    private EditText usuario, contrasena;
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
        usuario = findViewById(R.id.usuario);
        contrasena = findViewById(R.id.contrasena);
        btInicioSesion = findViewById(R.id.btInicioSesion);
    }

    public void validarUsuario(View v){

        String usuario = String.valueOf(this.usuario.getText());
        String contrasena = String.valueOf(this.contrasena.getText());

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this,"Debes rellenar los campos 'usuario' y 'contraseña' para acceder a la APP", Toast.LENGTH_LONG).show();
        } else {
            presenter.validarUsuario(usuario, contrasena);
        }

    }


    @Override
    public void usuarioCorrecto(ArrayList<Usuario> datosUsuario) {

            Intent navegar = new Intent(getBaseContext(), ListadoRestaurantes.class);
            startActivity(navegar);

    }

    @Override
    public void usuarioIncorrecto(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}