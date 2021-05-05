package com.example.glovo.beans;

import java.util.List;

public class Categoria {

    private int idCategoria;
    private String categoria;
    private List<Restaurante> listadoRestaurantes;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Restaurante> getListadoRestaurantes() {
        return listadoRestaurantes;
    }

    public void setListadoRestaurantes(List<Restaurante> listadoRestaurantes) {
        this.listadoRestaurantes = listadoRestaurantes;
    }
}
