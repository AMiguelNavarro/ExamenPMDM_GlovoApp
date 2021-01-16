/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class Valoracion {
    
    private String nombre, imagen;
    private int puntuacion;

    public Valoracion(String nombre, String imagen, int puntuacion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.puntuacion = puntuacion;
    }
    public Valoracion(){}

    
    /* GETTERS AND SETTERS */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    

    public static String toArrayJSon(ArrayList<Valoracion> arrayListValoraciones) {
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(arrayListValoraciones);

        return resp;
}
    
    
    
}
