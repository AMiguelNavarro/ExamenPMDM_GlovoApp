package com.example.glovo.listadoMenus.interfaces;

import android.content.Context;

import com.example.glovo.beans.Menu;

import java.util.ArrayList;

public interface ListadoMenusContrato {

    interface Vista {
        void listadoCorrecto(ArrayList<Menu> listaMenus);
        void listadoError(String error);
    }

    interface Presenter{
        void getMenus(Context context, int idRestaurante);
    }

    interface Modelo {

        interface OnMenusListener{
            void onCorrecto(ArrayList<Menu> listaMenus);
            void onError(String error);
        }

        void getMenusWS(Context context, OnMenusListener listener, int idRestaurante);

    }

}
