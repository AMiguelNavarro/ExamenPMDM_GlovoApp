/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.modelos;

import com.google.gson.Gson;
import java.util.ArrayList;

import com.google.gson.GsonBuilder;

/**
 *
 * @author alber
 */
public class Restaurante {
    
    private String nombre, imagen, descripcion;
    private int numVentas, idRestaurante, idCategoria;

    public Restaurante(String nombre, String imagen, String descripcion, int numVentas, int idRestaurante, int idCategoria) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this. numVentas = numVentas;
        this.idRestaurante = idRestaurante;
        this.idCategoria = idCategoria;
    }

    public Restaurante() {
    }

    //GETTERS & SETTERS

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getImagen() { return imagen;}

    public void setImagen(String imagen) { this.imagen = imagen;}

    public String getDescripcion() { return descripcion;}

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}
    
    public int getNumVentas() {return numVentas;}

    public void setNumVentas(int numVentas) {this.numVentas = numVentas;}

    public int getIdRestaurante() { return idRestaurante;}

    public void setIdRestaurante(int idRestaurante) {this.idRestaurante = idRestaurante;}

    public int getIdCategoria() {return idCategoria;}

    public void setIdCategoria(int idCategoria) {this.idCategoria = idCategoria;}
    
    

    @Override 
    public String toString() {
        return "Restaurante{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", numVentas=" + numVentas + ", idRestaurante=" + idRestaurante + ", idCategoria=" + idCategoria;
    }
    
    public static String toCadena(Restaurante restaurante) {
        return "Restaurante{" 
                + "nombre=" + restaurante.getNombre() + ", "
                + "descripción=" + restaurante.getDescripcion() + ","
                + "imagen=" + restaurante.getImagen() + ", "
                + "numVentas=" + restaurante.getNumVentas() + ", "
                + "idRestaurante=" + restaurante.getIdRestaurante() + ", "
                + "idCategoria=" + restaurante.getIdCategoria();
                
    }
    
    /**
     * Convierte un arrayList en JSON
     * @param arrayListRestaurantes
     * @return 
     */
    public static String 
        toArrayJSon(ArrayList<Restaurante> arrayListRestaurantes) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(arrayListRestaurantes);
            
            return resp;
    }
        
    public static String toObjectJson(Restaurante restaurante){
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(restaurante);
        return resp;
    }    
    
}
