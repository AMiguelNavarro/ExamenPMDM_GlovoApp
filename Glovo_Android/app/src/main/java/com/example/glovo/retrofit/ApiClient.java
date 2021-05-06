package com.example.glovo.retrofit;

import android.content.Context;

import com.example.glovo.BuildConfig;
import com.example.glovo.beans.Categoria;
import com.example.glovo.beans.Menu;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.Usuario;
import com.example.glovo.beans.Valoracion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Retrofit retrofit;
    private Context context;

    public ApiClient(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // ENDPOINTS

    public Call<Usuario> getUsuario(String user, String pw) {
        UsuariosApiRetrofit service = retrofit.create(UsuariosApiRetrofit.class);
        return service.getUsuario(user, pw);
    }

    public Call<List<Restaurante>> getRestaurantes() {
        RestaurantesApiRetrofit service = retrofit.create(RestaurantesApiRetrofit.class);
        return service.getRestaurantes();
    }

    public Call<List<Restaurante>> getTop10() {
        RestaurantesApiRetrofit service = retrofit.create(RestaurantesApiRetrofit.class);
        return service.getTop10();
    }

    public Call<List<Valoracion>> getValoraciones() {
        ValoracionesApiRetrofit service = retrofit.create(ValoracionesApiRetrofit.class);
        return service.getValoraciones();
    }

    public Call<List<Categoria>> getCategorias() {
        CategoriasApiRetrofit service = retrofit.create(CategoriasApiRetrofit.class);
        return  service.getCategorias();
    }

    public Call<List<Menu>> getMenus(int idRestaurante) {
        MenusApiRetrofit service = retrofit.create(MenusApiRetrofit.class);
        return service.getMenus(idRestaurante);
    }

}
