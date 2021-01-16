package com.example.glovo.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Valoracion {

    private static final String NOMBRE_RESTAURANTE = "nombre";
    private static final String PUNTUACION_MEDIA = "puntuacion";
    private static final String IMAGEN = "imagen";

    private String nombre, imagen;
    private int puntuacion;




    /* GETTERS Y SETTERS */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



    public static ArrayList<Valoracion> getArrayListFromJSON(JSONArray listaValoraciones) {
        ArrayList<Valoracion> lstValoraciones = null;
        try {
            if (listaValoraciones != null && listaValoraciones.length() > 0) {
                lstValoraciones = new ArrayList<Valoracion>();
            }

            for (int i = 0; i < listaValoraciones.length(); i++) {
                JSONObject json_data = listaValoraciones.getJSONObject(i);
                Valoracion valoracion = new Valoracion();

                valoracion.setNombre(json_data.getString(NOMBRE_RESTAURANTE));
                valoracion.setImagen(json_data.getString(IMAGEN));
                valoracion.setPuntuacion(json_data.getInt(PUNTUACION_MEDIA));

                lstValoraciones.add(valoracion);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lstValoraciones;
    }

}
