package com.example.glovo.listadoTop10.interfaces;

import android.content.Context;

import com.example.glovo.beans.Restaurante;

import java.util.ArrayList;

public interface ListadoTop10Contrato {

    interface Vista {

        void listadoCorrecto(ArrayList<Restaurante> listaRestaurantesTop10);
        void listadoError(String error);

    }


    interface Presenter {

        void getTop10(Context context);

    }


    interface Modelo {

        interface OnTop10Listener {
            void onCorrecto(ArrayList<Restaurante> listaRestaurantesTop10);
            void onError(String error);
        }

        void getTop10WS(Context context, OnTop10Listener listener);

    }

}
