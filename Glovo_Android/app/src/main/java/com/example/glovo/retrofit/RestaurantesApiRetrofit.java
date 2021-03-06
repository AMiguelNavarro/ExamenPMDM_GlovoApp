package com.example.glovo.retrofit;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.RestauranteDTO;
import com.example.glovo.beans.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestaurantesApiRetrofit {

    @GET("restaurantes")
    Call<List<Restaurante>> getRestaurantes();

    @GET("restaurantes/top10")
    Call<List<Restaurante>> getTop10();

    @GET("restaurantes/filtro")
    Call<List<Restaurante>> getRestaurantesFiltrados(@Query("categoria") String categoria);

    @POST("/restaurantes")
    Call<Restaurante> addRestaurante(@Body RestauranteDTO restauranteDTO);

}
