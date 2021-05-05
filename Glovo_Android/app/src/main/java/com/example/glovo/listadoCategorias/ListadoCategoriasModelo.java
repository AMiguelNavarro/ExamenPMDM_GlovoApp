package com.example.glovo.listadoCategorias;

import android.content.Context;

import com.example.glovo.beans.Categoria;
import com.example.glovo.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListadoCategoriasModelo implements ListadoCategoriasContrato.Modelo{


    @Override
    public void getCategoriasWS(Context context, OnListenerCategoria listener) {
        ApiClient api = new ApiClient(context);
        final Call<List<Categoria>> peticion = api.getCategorias();
        peticion.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                listener.onCorrecto(new ArrayList<>(response.body()));
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                t.printStackTrace();
                listener.onError(t.getLocalizedMessage());
            }
        });
    }
}
