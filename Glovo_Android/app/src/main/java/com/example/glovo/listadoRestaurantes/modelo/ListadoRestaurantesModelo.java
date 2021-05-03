package com.example.glovo.listadoRestaurantes.modelo;

import android.content.Context;
import android.os.AsyncTask;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.retrofit.ApiClient;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListadoRestaurantesModelo implements ListadoRestaurantesContrato.Modelo {


    @Override
    public void getRestaurantesWS(Context context, OnLstRestaurantesListener onLstRestaurantesListener) {

        ApiClient api = new ApiClient(context);
        final Call<List<Restaurante>> peticion = api.getRestaurantes();
        peticion.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response != null && response.body() != null) {
                    onLstRestaurantesListener.onCorrecto(new ArrayList<Restaurante>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                t.printStackTrace();
                onLstRestaurantesListener.onError("Error al traer el listado de restaurantes");
            }
        });

    }




}
