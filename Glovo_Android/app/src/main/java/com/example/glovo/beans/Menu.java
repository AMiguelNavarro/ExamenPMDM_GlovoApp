package com.example.glovo.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Menu {

    private static final String PRIMERO = "primero";
    private static final String SEGUNDO = "segundo";
    private static final String POSTRE = "postre";
    private static final String BEBIDA = "bebida";
    private static final String NOMBRE_MENU = "nombreMenu";
    private static final String IMAGEN_MENU = "imagenMenu";
    private static final String PRECIO = "precio";

    private double precio;
    private String primero, segundo, postre, bebida, nombreMenu, imagenMenu;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPrimero() {
        return primero;
    }

    public void setPrimero(String primero) {
        this.primero = primero;
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getImagenMenu() {
        return imagenMenu;
    }

    public void setImagenMenu(String imagenMenu) {
        this.imagenMenu = imagenMenu;
    }



    public static ArrayList<Menu> getArrayListFromJSON(JSONArray listaMenus) {

        ArrayList<Menu> lstMenus = null;

        try {

            if (listaMenus != null && listaMenus.length() > 0) {
                lstMenus = new ArrayList<>();
            }

            for (int i = 0; i < listaMenus.length(); i++) {
                JSONObject json_data = listaMenus.getJSONObject(i);
                Menu menu = new Menu();

                menu.setPrimero(json_data.getString(PRIMERO));
                menu.setSegundo(json_data.getString(SEGUNDO));
                menu.setPostre(json_data.getString(POSTRE));
                menu.setBebida(json_data.getString(BEBIDA));
                menu.setNombreMenu(json_data.getString(NOMBRE_MENU));
                menu.setImagenMenu(json_data.getString(IMAGEN_MENU));
                menu.setPrecio(json_data.getDouble(PRECIO));

                lstMenus.add(menu);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lstMenus;

    }
}
