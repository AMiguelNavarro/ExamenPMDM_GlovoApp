package com.example.glovo.loginInicio.interfaces;

import com.example.glovo.beans.Usuario;

import java.util.ArrayList;

public interface LoginInterfazContrato {

    interface Vista{
        void usuarioCorrecto(ArrayList<Usuario> datosUsuario);
        void usuarioIncorrecto(String error);
    }

    interface Presenter{
        void validarUsuario(String usuario, String contrasena);
    }

    interface Modelo{

        interface OnLoginListener{
            void onUsuarioCorrecto(ArrayList<Usuario> datosUsuario);
            void onUsuarioIncorrecto(String error);
        }

        void validarUsuarioWS(OnLoginListener listener, String usuario, String contrasena);

    }

}
