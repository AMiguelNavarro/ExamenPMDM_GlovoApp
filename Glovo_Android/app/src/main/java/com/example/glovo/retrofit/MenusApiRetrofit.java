package com.example.glovo.retrofit;

import com.example.glovo.beans.Menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MenusApiRetrofit {

    @GET("menus")
    Call<List<Menu>> getMenus(
            @Query("idRestaurante") int idRestaurante
    );

}
