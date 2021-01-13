package com.example.glovo.listadoRestaurantes.modelo;

import android.os.AsyncTask;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;

import java.util.ArrayList;


public class ListadoRestaurantesModelo implements ListadoRestaurantesContrato.Modelo {

    private ArrayList<Restaurante> listaRestaurantesArrayList;
    private OnLstRestaurantesListener onLstRestaurantesListener;


    public ListadoRestaurantesModelo() { }

    @Override
    public void getRestaurantesWS(OnLstRestaurantesListener onLstRestaurantesListener) {

        this.onLstRestaurantesListener = onLstRestaurantesListener;
        TareaEnSegundoPlano hilo = new TareaEnSegundoPlano();
        hilo.execute();

//        onLstRestaurantesListener.onCorrecto();
//        onLstRestaurantesListener.onError();


    }

    /**
     * Clase que realiza el asyntask en segundo plano a la base de datos y devuelve una respuesta al presenter con la programación reactiva
     */
    class TareaEnSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaRestaurantesArrayList != null && listaRestaurantesArrayList.size() > 0) {
                    onLstRestaurantesListener.onCorrecto(listaRestaurantesArrayList);
                } else {
                    onLstRestaurantesListener.onError("Error al traer los datos del servidor");
                }
            }
        }
    }

}
