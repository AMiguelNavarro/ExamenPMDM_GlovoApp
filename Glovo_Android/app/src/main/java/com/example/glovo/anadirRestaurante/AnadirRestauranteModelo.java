package com.example.glovo.anadirRestaurante;

import android.content.Context;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.RestauranteDTO;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnadirRestauranteModelo implements AnadirRestauranteContrato.Modelo{

    @Override
    public void addRestauranteWS(Context context, OnRestauranteListener onRestauranteListener, RestauranteDTO restauranteDTO) {
        ApiClient api = new ApiClient(context);
        final Call<Restaurante> peticion = api.addRestaurante(restauranteDTO);
        peticion.enqueue(new Callback<Restaurante>() {
            @Override
            public void onResponse(Call<Restaurante> call, Response<Restaurante> response) {
                onRestauranteListener.onAnadido(response.body());
            }

            @Override
            public void onFailure(Call<Restaurante> call, Throwable t) {
                onRestauranteListener.onError(t.getLocalizedMessage());
            }
        });
    }
}
