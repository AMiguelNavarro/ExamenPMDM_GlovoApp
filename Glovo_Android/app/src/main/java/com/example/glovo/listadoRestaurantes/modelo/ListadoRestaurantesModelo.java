package com.example.glovo.listadoRestaurantes.modelo;

import android.os.AsyncTask;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoRestaurantes.interfaces.ListadoRestaurantesContrato;
import com.example.glovo.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ListadoRestaurantesModelo implements ListadoRestaurantesContrato.Modelo {

    private static final String URL_SERVER = "http://192.168.0.18:8080/GlovoServlet/Controlador";

    private ArrayList<Restaurante> listaRestaurantesArrayList;
    private OnLstRestaurantesListener onLstRestaurantesListener;


    public ListadoRestaurantesModelo() {
    }

    /**
     * Método que inicia la tarea en segundo plano
     *
     * @param onLstRestaurantesListener
     */
    @Override
    public void getRestaurantesWS(OnLstRestaurantesListener onLstRestaurantesListener) {

        this.onLstRestaurantesListener = onLstRestaurantesListener;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "RESTAURANTES.FIND_ALL");

        TareaEnSegundoPlano hilo = new TareaEnSegundoPlano(param);
        hilo.execute(URL_SERVER);

    }


    /**
     * Clase que realiza en segundo plano la petición a la base de datos y devuelve una respuesta al presenter con la programación reactiva
     */
    class TareaEnSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros = null;

        public TareaEnSegundoPlano(HashMap<String, String> parametros) {
            super();
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            String url_seleccionada = strings[0];
            Post post = new Post();

            try {

                // Devuelve el objeto JSON
                JSONArray listaRestaurantesJSON = post.getServerDataPost(parametros, url_seleccionada);

                // Se convierte a ArrayList el JSON
                listaRestaurantesArrayList = Restaurante.getArrayListFromJSON(listaRestaurantesJSON);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Devolver si ha ido bien o mal
            return true;
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
