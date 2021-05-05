package com.example.glovo.retrofit;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.Valoracion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ValoracionesApiRetrofit {

    @GET("valoraciones")
    Call<List<Valoracion>> getValoraciones();

}
