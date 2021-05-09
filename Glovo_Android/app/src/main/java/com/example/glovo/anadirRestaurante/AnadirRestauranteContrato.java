package com.example.glovo.anadirRestaurante;

import android.content.Context;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.beans.RestauranteDTO;

public interface AnadirRestauranteContrato {

    interface Vista {

        void onAnadido(Restaurante nuevoRestaurante);
        void onError(String error);

    }

    interface Presenter {
        void addRestaurante(Context context, RestauranteDTO restauranteDTO);
    }

    interface Modelo {

        /**
         * Programación reactiva, le indica el camino de regreso
         */
        interface OnRestauranteListener {
            void onAnadido(Restaurante nuevoRestaurante);
            void onError(String error);
        }

        void addRestauranteWS(Context context, AnadirRestauranteContrato.Modelo.OnRestauranteListener onRestauranteListener, RestauranteDTO restauranteDTO);
    }

}
