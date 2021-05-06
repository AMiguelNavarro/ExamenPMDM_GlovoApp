package com.example.glovo.listadoMenus.presenter;

import android.content.Context;

import com.example.glovo.beans.Menu;
import com.example.glovo.listadoMenus.interfaces.ListadoMenusContrato;
import com.example.glovo.listadoMenus.modelo.ListadoMenusModelo;
import com.example.glovo.listadoMenus.vista.ListadoMenusVista;

import java.util.ArrayList;

public class ListadoMenusPresenter implements ListadoMenusContrato.Presenter {

    private ListadoMenusVista vista;
    private ListadoMenusModelo modelo;

    public ListadoMenusPresenter(ListadoMenusVista vista) {
        this.vista = vista;
        modelo = new ListadoMenusModelo();
    }


    @Override
    public void getMenus(Context context, int idRestaurante) {
        modelo.getMenusWS(context, new ListadoMenusContrato.Modelo.OnMenusListener() {
            @Override
            public void onCorrecto(ArrayList<Menu> listaMenus) {
                vista.listadoCorrecto(listaMenus);
            }

            @Override
            public void onError(String error) {
                vista.listadoError(error);
            }
        }, idRestaurante);
    }
}
