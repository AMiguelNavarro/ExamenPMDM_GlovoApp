package com.example.glovo.loginInicio.modelo;

import android.content.Context;

import com.example.glovo.beans.Usuario;
import com.example.glovo.loginInicio.interfaces.LoginInterfazContrato;
import com.example.glovo.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModelo implements LoginInterfazContrato.Modelo {


    @Override
    public void validarUsuarioWS(Context context, OnLoginListener listener, String usuario, String contrasena) {
        ApiClient api = new ApiClient(context);
        final Call<Usuario> peticion = api.getUsuario(usuario, contrasena);
        peticion.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response != null && response.body() != null) {
                    Usuario user = new Usuario();
                    user.setUsuario(response.body().getUsuario());
                    user.setIdUsuario(response.body().getIdUsuario());
                    listener.onUsuarioCorrecto(user);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                listener.onUsuarioIncorrecto("Usuario incorrecto");
            }
        });
    }

}
