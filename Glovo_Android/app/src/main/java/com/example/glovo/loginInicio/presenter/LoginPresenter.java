package com.example.glovo.loginInicio.presenter;

import com.example.glovo.beans.Usuario;
import com.example.glovo.loginInicio.interfaces.LoginInterfazContrato;
import com.example.glovo.loginInicio.modelo.LoginModelo;
import com.example.glovo.loginInicio.vista.LoginVista;

import java.util.ArrayList;

public class LoginPresenter implements LoginInterfazContrato.Presenter {

    private LoginModelo modelo;
    private LoginVista vista;

    public LoginPresenter(LoginVista vista) {
        this.vista = vista;
        modelo = new LoginModelo();
    }


    @Override
    public void validarUsuario(String usuario, String contrasena) {
        modelo.validarUsuarioWS(new LoginInterfazContrato.Modelo.OnLoginListener() {
            @Override
            public void onUsuarioCorrecto(ArrayList<Usuario> datosUsuario) {
                vista.usuarioCorrecto(datosUsuario);
            }

            @Override
            public void onUsuarioIncorrecto(String error) {
                vista.usuarioIncorrecto(error);
            }
        }, usuario, contrasena);
    }
}
