package com.example.glovo.retrofit;

import com.example.glovo.beans.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsuariosApiRetrofit {

    @GET("usuarios")
    Call<Usuario> getUsuario(@Query("usuario") String user, @Query("password") String pw);
}
