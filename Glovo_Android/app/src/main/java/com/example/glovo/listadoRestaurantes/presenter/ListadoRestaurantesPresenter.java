package com.example.glovo.listadoRestaurantes.presenter;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.listadoRestaurantes.modelo.ListadoRestaurantesModelo;

import java.util.ArrayList;

public class ListadoRestaurantesPresenter implements ListadoRestaurantesContrato.Presenter {

    private ListadoRestaurantesContrato.Vista vista;
    private ListadoRestaurantesModelo modelo;

    public ListadoRestaurantesPresenter(ListadoRestaurantesContrato.Vista vista) {
        this.vista = vista;
        this.modelo = new ListadoRestaurantesModelo();
    }

    /**
     * Habla con el modelo, y desencadena acción en la vista según lo que reciba
     * Como parámetro instancia la programación reactiva para poder darle al modelo el camino de regreso y comunicar con la vista dentro de esto métodos
     */
    @Override
    public void getRestaurantes() {

        modelo.getRestaurantesWS(new ListadoRestaurantesContrato.Modelo.OnLstRestaurantesListener() {

            /**
             * Si es correcto devuelve la lista con los restaurantes que ha sacado de la BD
             * @param listaRestaurantes
             */
            @Override
            public void onCorrecto(ArrayList<Restaurante> listaRestaurantes) {
                vista.listadoCorrecto(listaRestaurantes);
            }

            /**
             * Si hay algún error devuelve un mensaje de error
             * @param error
             */
            @Override
            public void onError(String error) {
                vista.listadoError(error);
            }
        });

    }

}
