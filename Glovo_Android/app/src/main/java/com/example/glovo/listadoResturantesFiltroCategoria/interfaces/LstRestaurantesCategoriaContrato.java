package com.example.glovo.listadoResturantesFiltroCategoria.interfaces;

import android.content.Context;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;

import java.util.ArrayList;

public interface LstRestaurantesCategoriaContrato {

     interface Vista {

        void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes);
        void listadoError(String error);

    }

     interface Presenter {
        void getRestaurantesCategoria(Context context, String categoria);
    }

     interface Modelo {

         void getRestaurantesCategoriaWS(Context context, OnLstRestaurantesListenerCategoria onLstRestaurantesListenerCategoria, String categoria);

        /**
         * Programación reactiva, le indica el camino de regreso
         */
        interface OnLstRestaurantesListenerCategoria {
            void onCorrecto(ArrayList<Restaurante> listaRestaurantes);
            void onError(String error);
        }


    }

}
