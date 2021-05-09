package com.example.glovo.listadoValoraciones.modelo;

import android.content.Context;
import android.os.AsyncTask;

import com.example.glovo.beans.Valoracion;
import com.example.glovo.listadoValoraciones.interfaces.ListadoValoracionesContrato;
import com.example.glovo.retrofit.ApiClient;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoValoracionesModelo implements ListadoValoracionesContrato.Modelo {


    @Override
    public void getValoracionesWS(Context context, OnListenerValoracion listener) {
        ApiClient api = new ApiClient(context);
        final Call<List<Valoracion>> peticion = api.getValoraciones();
        peticion.enqueue(new Callback<List<Valoracion>>() {
            @Override
            public void onResponse(Call<List<Valoracion>> call, Response<List<Valoracion>> response) {
                if (response != null && response.body() != null) {
                    listener.onCorrecto(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Valoracion>> call, Throwable t) {
                t.printStackTrace();
                listener.onError("Error al mostrar las valoraciones");
            }
        });

    }

}
