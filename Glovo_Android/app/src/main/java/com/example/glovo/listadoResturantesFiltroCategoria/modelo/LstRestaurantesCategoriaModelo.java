package com.example.glovo.listadoResturantesFiltroCategoria.modelo;

import android.content.Context;
import android.os.AsyncTask;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoResturantesFiltroCategoria.interfaces.LstRestaurantesCategoriaContrato;
import com.example.glovo.retrofit.ApiClient;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstRestaurantesCategoriaModelo implements LstRestaurantesCategoriaContrato.Modelo {

    @Override
    public void getRestaurantesCategoriaWS(Context context, OnLstRestaurantesListenerCategoria onLstRestaurantesListenerCategoria, String categoria) {
        ApiClient api = new ApiClient(context);
        final Call<List<Restaurante>> peticion = api.getRestaurantesFiltrados(categoria);
        peticion.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response.body() != null) {
                    onLstRestaurantesListenerCategoria.onCorrecto(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                onLstRestaurantesListenerCategoria.onError(t.getLocalizedMessage());
            }
        });
    }


}
