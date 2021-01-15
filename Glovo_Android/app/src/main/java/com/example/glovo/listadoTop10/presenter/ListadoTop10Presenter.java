package com.example.glovo.listadoTop10.presenter;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;
import com.example.glovo.listadoTop10.modelo.ListadoTop10Modelo;

import java.util.ArrayList;

public class ListadoTop10Presenter implements ListadoTop10Contrato.Presenter {

    private ListadoTop10Contrato.Vista vistaContrato;
    private ListadoTop10Modelo modelo;

    public ListadoTop10Presenter(ListadoTop10Contrato.Vista vistaContrato) {
        this.vistaContrato = vistaContrato;
        modelo = new ListadoTop10Modelo();
    }


    @Override
    public void getTop10() {
        modelo.getTop10WS(new ListadoTop10Contrato.Modelo.OnTop10Listener() {

            @Override
            public void onCorrecto(ArrayList<Restaurante> listaRestaurantesTop10) {
                vistaContrato.listadoCorrecto(listaRestaurantesTop10);
            }

            @Override
            public void onError(String error) {
                vistaContrato.listadoError(error);
            }

        });
    }
}
