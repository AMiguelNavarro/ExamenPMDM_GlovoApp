/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.modelos;

/**
 *
 * @author alber
 */
public class Categoria {
    
    private String categoria;
    private int idCategoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoria=" + categoria + ", idCategoria=" + idCategoria + '}';
    }
    
    
}
