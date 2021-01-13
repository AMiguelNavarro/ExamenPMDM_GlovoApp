package com.example.glovo.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Restaurante {

    private int idRestaurante, idCategoria, numVentas;
    private String nombre, imagen, descripción;

    public Restaurante(int idRestaurante, int idCategoria, int numVentas, String nombre, String imagen, String descripción) {
        this.idRestaurante = idRestaurante;
        this.idCategoria = idCategoria;
        this.numVentas = numVentas;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripción = descripción;
    }

    /* GETTERS AND SETTERS */ // CTRL + SHIFT + - --> para contraer todo de golpe

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

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

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }



//    public static ArrayList<Restaurante> getArrayListFromJSON(JSONArray listaRestaurantes) {
//        ArrayList<Restaurante> lstRestaurantes = null;
//        try {
//            if (lstRestaurantes != null && lstRestaurantes.length() > 0) {
//                lstRestaurantes = new ArrayList<Restaurante>();
//            }
//
//            // Se recorre la lista que llega por parámetro y se mete en un objeto Pelicula
//            for (int i = 0; i < lstRestaurantes.length(); i++) {
//                JSONObject json_data = lstRestaurantes.getJSONObject(i);
//                Peliculas pelicula = new Peliculas();
//
//                pelicula.setId(json_data.getInt(ID));
//                pelicula.setTitulo(json_data.getString(TITLE));
//                pelicula.setSinopsis(json_data.getString(OVERVIEW));
//                pelicula.setImage(json_data.getString(POSTER_PATH));
//                pelicula.setVote_average(json_data.getString(VOTE_AVERAGE));
//
//
//                lstRestaurantes.add(pelicula);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return lstRestaurantes;
//    }


}
