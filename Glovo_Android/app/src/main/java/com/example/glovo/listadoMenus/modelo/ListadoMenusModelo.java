package com.example.glovo.listadoMenus.modelo;

import android.content.Context;
import android.os.AsyncTask;

import com.example.glovo.beans.Menu;
import com.example.glovo.listadoMenus.interfaces.ListadoMenusContrato;
import com.example.glovo.retrofit.ApiClient;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoMenusModelo implements ListadoMenusContrato.Modelo {


    @Override
    public void getMenusWS(Context context, OnMenusListener listener, int idRestaurante) {
        ApiClient api = new ApiClient(context);
        final Call<List<Menu>> peticion = api.getMenus(idRestaurante);
        peticion.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                listener.onCorrecto(new ArrayList<>(response.body()));
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                t.printStackTrace();
                listener.onError(t.getLocalizedMessage());
            }
        });

    }


}
