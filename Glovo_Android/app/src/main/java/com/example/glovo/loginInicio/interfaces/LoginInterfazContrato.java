package com.example.glovo.loginInicio.interfaces;

import android.content.Context;

import com.example.glovo.beans.Usuario;

import java.util.ArrayList;

public interface LoginInterfazContrato {

    interface Vista{
        void usuarioCorrecto(Usuario datosUsuario);
        void usuarioIncorrecto(String error);
    }

    interface Presenter{
        void validarUsuario(Context context, String usuario, String contrasena);
    }

    interface Modelo{

        interface OnLoginListener{
            void onUsuarioCorrecto(Usuario datosUsuario);
            void onUsuarioIncorrecto(String error);
        }

        void validarUsuarioWS(Context context, OnLoginListener listener, String usuario, String contrasena);

    }

}
