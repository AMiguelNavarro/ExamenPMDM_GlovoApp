package com.example.glovo.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Restaurante {

    // Poner las etiquetas por las que me llegan los datos en JSON
    private static final String ID_RESTAURANTE = "idRestaurante";
    private static final String ID_CATEGORIA = "idCategoria";
    private static final String NOMBRE = "nombre";
    private static final String IMAGEN = "imagen";
    private static final String DESCRIPCION = "descripcion";
    private static final String NUMERO_VENTAS = "numVentas";

    private int idRestaurante, idCategoria, numVentas;
    private String nombre, imagen, descripción;

    public Restaurante() { /*CONSTRUCTOR VACIO */ }



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



    public static ArrayList<Restaurante> getArrayListFromJSON(JSONArray listaRestaurantes) {
        ArrayList<Restaurante> lstRestaurantes = null;
        try {
            if (listaRestaurantes != null && listaRestaurantes.length() > 0) {
                lstRestaurantes = new ArrayList<Restaurante>();
            }

            // Se recorre la lista que llega por parámetro y se mete en un objeto Pelicula
            for (int i = 0; i < listaRestaurantes.length(); i++) {
                JSONObject json_data = listaRestaurantes.getJSONObject(i);
                Restaurante restaurante = new Restaurante();

                restaurante.setIdRestaurante(json_data.getInt(ID_RESTAURANTE));
                restaurante.setIdCategoria(json_data.getInt(ID_CATEGORIA));
                restaurante.setNombre(json_data.getString(NOMBRE));
                restaurante.setDescripción(json_data.getString(DESCRIPCION));
                restaurante.setImagen(json_data.getString(IMAGEN));
                restaurante.setNumVentas(json_data.getInt(NUMERO_VENTAS));


                lstRestaurantes.add(restaurante);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lstRestaurantes;
    }


}
