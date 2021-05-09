package com.example.glovo.anadirRestaurante;

import android.content.Context;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.RestauranteDTO;

public class AnadirRestaurantePresenter implements AnadirRestauranteContrato.Presenter{

    private AnadirRestauranteContrato.Vista vista;
    private AnadirRestauranteModelo modelo;
    private RestauranteDTO restauranteDTO;

    public AnadirRestaurantePresenter(AnadirRestauranteContrato.Vista vista) {
        this.vista = vista;
        modelo = new AnadirRestauranteModelo();
        restauranteDTO = new RestauranteDTO();
    }

    @Override
    public void addRestaurante(Context context, RestauranteDTO restauranteDTO) {
        this.restauranteDTO = restauranteDTO;
        modelo.addRestauranteWS(context, new AnadirRestauranteContrato.Modelo.OnRestauranteListener() {
            @Override
            public void onAnadido(Restaurante nuevoRestaurante) {
                vista.onAnadido(nuevoRestaurante);
            }

            @Override
            public void onError(String error) {
                vista.onError(error);
            }
        }, restauranteDTO);
    }
}
