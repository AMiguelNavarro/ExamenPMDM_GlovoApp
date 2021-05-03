package com.example.glovo.listadoRestaurantes.interfaces;

import android.content.Context;

import com.example.glovo.beans.Restaurante;

import java.util.ArrayList;

/**
 * Métodos con los que se va a comunicar cada clase del patrón MVP para segmentarlo bien y evitar que otras clases puedan acceder a ellos
 */
public interface ListadoRestaurantesContrato {

     interface Vista {

        void listadoCorrecto(ArrayList<Restaurante> listaRestaurantes);
        void listadoError(String error);

    }

     interface Presenter {
        void getRestaurantes(Context context);
    }

     interface Modelo {

        /**
         * Programación reactiva, le indica el camino de regreso
         */
        interface OnLstRestaurantesListener {
            void onCorrecto(ArrayList<Restaurante> listaRestaurantes);
            void onError(String error);
        }

        void getRestaurantesWS(Context context, OnLstRestaurantesListener onLstRestaurantesListener);
    }

}
