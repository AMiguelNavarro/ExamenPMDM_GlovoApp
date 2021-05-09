package com.example.glovo.listadoResturantesFiltroCategoria.presenter;

import android.content.Context;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoResturantesFiltroCategoria.interfaces.LstRestaurantesCategoriaContrato;
import com.example.glovo.listadoResturantesFiltroCategoria.modelo.LstRestaurantesCategoriaModelo;

import java.util.ArrayList;

public class LstRestaurantesCategoriaPresenter implements LstRestaurantesCategoriaContrato.Presenter {

    private LstRestaurantesCategoriaContrato.Vista vistaCategoriaContrato;
    private LstRestaurantesCategoriaModelo modeloCategoria;
    private String categoria;

    /**
     * Constructor
     * @param vistaCategoriaContrato
     */
    public LstRestaurantesCategoriaPresenter(LstRestaurantesCategoriaContrato.Vista vistaCategoriaContrato) {
        this.vistaCategoriaContrato = vistaCategoriaContrato;
        modeloCategoria = new LstRestaurantesCategoriaModelo();

    }



    @Override
    public void getRestaurantesCategoria(Context context, String categoria) {

        modeloCategoria.getRestaurantesCategoriaWS(context, new LstRestaurantesCategoriaContrato.Modelo.OnLstRestaurantesListenerCategoria() {
            @Override
            public void onCorrecto(ArrayList<Restaurante> listaRestaurantes) {
                vistaCategoriaContrato.listadoCorrecto(listaRestaurantes);
            }

            @Override
            public void onError(String error) {
                vistaCategoriaContrato.listadoError(error);
            }
        }, categoria);

    }
}
