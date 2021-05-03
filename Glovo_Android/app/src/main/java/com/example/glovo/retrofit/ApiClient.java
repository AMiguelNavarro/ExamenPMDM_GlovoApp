package com.example.glovo.retrofit;

import android.content.Context;

import com.example.glovo.BuildConfig;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.Usuario;

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

}
