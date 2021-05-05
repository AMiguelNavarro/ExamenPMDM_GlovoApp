package com.example.glovo.listadoCategorias;

import android.content.Context;

import com.example.glovo.beans.Categoria;

import java.util.ArrayList;

public class ListadoCategoriasPresenter implements ListadoCategoriasContrato.Presenter{

    private ListadoCategoriasContrato.Vista vista;
    private ListadoCategoriasModelo modelo;

    public ListadoCategoriasPresenter(ListadoCategoriasContrato.Vista vista) {
        this.vista = vista;
        this.modelo = new ListadoCategoriasModelo();
    }

    @Override
    public void getCategorias(Context context) {
        modelo.getCategoriasWS(context, new ListadoCategoriasContrato.Modelo.OnListenerCategoria() {
            @Override
            public void onCorrecto(ArrayList<Categoria> listaCategorias) {
                vista.listadoCategoriasCorrecto(listaCategorias);
            }

            @Override
            public void onError(String error) {
                vista.listadoCategoriasError(error);
            }
        });
    }
}
