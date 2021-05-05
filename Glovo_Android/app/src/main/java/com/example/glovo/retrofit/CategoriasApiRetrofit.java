package com.example.glovo.retrofit;

import com.example.glovo.beans.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriasApiRetrofit {

    @GET("categorias")
    Call<List<Categoria>> getCategorias();

}
