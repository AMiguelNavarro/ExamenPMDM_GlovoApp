package com.example.glovo.listadoTop10.modelo;

import android.content.Context;
import android.os.AsyncTask;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;
import com.example.glovo.retrofit.ApiClient;
import com.example.glovo.utils.Post;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListadoTop10Modelo implements ListadoTop10Contrato.Modelo {


    @Override
    public void getTop10WS(Context context, OnTop10Listener listener) {
        ApiClient api = new ApiClient(context);
        final Call<List<Restaurante>> peticion = api.getTop10();
        peticion.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response != null && response.body() != null) {
                    listener.onCorrecto(new ArrayList<Restaurante>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                t.printStackTrace();
                listener.onError(t.getLocalizedMessage());
            }
        });
    }


}
