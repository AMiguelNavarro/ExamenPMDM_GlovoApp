package com.example.glovo.listadoResturantesFiltroCategoria.modelo;

import android.os.AsyncTask;

import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoResturantesFiltroCategoria.interfaces.LstRestaurantesCategoriaContrato;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class LstRestaurantesCategoriaModelo implements LstRestaurantesCategoriaContrato.Modelo {

    private ArrayList<Restaurante> listaRestCategoria;
    private OnLstRestaurantesListenerCategoria listenerCategoria;

    private static final String URL_SERVER = "http://192.168.0.18:8080/GlovoServlet/Controlador";


    @Override
    public void getRestaurantesCategoriaWS(OnLstRestaurantesListenerCategoria onLstRestaurantesListenerCategoria, String categoria) {

        listenerCategoria = onLstRestaurantesListenerCategoria;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "RESTAURANTES.CATEGORIA");
        param.put("CATEGORIA", categoria);

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
                listaRestCategoria = Restaurante.getArrayListFromJSON(listaRestaurantesJSON);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Devolver si ha ido bien o mal
            return true;
        }

        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaRestCategoria != null && listaRestCategoria.size() > 0) {
                    listenerCategoria.onCorrecto(listaRestCategoria);
                } else {
                    listenerCategoria.onError("Error al traer los datos del servidor");
                }
            }
        }
    }
}
