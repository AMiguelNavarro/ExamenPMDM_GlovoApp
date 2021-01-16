package com.example.glovo.listadoValoraciones.interfaces;

import com.example.glovo.beans.Valoracion;

import java.util.ArrayList;

public interface ListadoValoracionesContrato {

    interface Vista {
        void listadoCorrecto(ArrayList<Valoracion> listaValoraciones);
        void listadoError(String error);
    }

    interface Presenter{
        void getValoraciones();
    }

    interface Modelo{

        interface OnListenerValoracion{
            void onCorrecto(ArrayList<Valoracion> listaValoraciones);
            void onError(String error);
        }

        void getValoracionesWS(OnListenerValoracion listener);

    }

}
