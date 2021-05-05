package com.example.glovo.listadoValoraciones.presenter;

import android.content.Context;

import com.example.glovo.beans.Valoracion;
import com.example.glovo.listadoValoraciones.interfaces.ListadoValoracionesContrato;
import com.example.glovo.listadoValoraciones.modelo.ListadoValoracionesModelo;

import java.util.ArrayList;

public class ListadoValoracionesPresenter implements ListadoValoracionesContrato.Presenter {

    private ListadoValoracionesContrato.Vista vistaContrato;
    private ListadoValoracionesModelo modelo;


    public ListadoValoracionesPresenter(ListadoValoracionesContrato.Vista vistaContrato) {
        this.vistaContrato = vistaContrato;
        modelo = new ListadoValoracionesModelo();
    }

    @Override
    public void getValoraciones(Context context) {
        modelo.getValoracionesWS(context, new ListadoValoracionesContrato.Modelo.OnListenerValoracion() {
            @Override
            public void onCorrecto(ArrayList<Valoracion> listaValoraciones) {
                vistaContrato.listadoCorrecto(listaValoraciones);
            }

            @Override
            public void onError(String error) {
                vistaContrato.listadoError(error);
            }
        });
    }
}
