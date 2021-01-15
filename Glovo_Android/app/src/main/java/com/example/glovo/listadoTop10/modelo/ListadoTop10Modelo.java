package com.example.glovo.listadoTop10.modelo;

import android.os.AsyncTask;
import com.example.glovo.beans.Restaurante;
import com.example.glovo.listadoTop10.interfaces.ListadoTop10Contrato;
import com.example.glovo.utils.Post;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.HashMap;

public class ListadoTop10Modelo implements ListadoTop10Contrato.Modelo {

    private static final String URL_SERVER = "http://192.168.0.18:8080/GlovoServlet/Controlador";

    private ArrayList<Restaurante> listaTop10;
    private OnTop10Listener listener;



    @Override
    public void getTop10WS(OnTop10Listener listener) {
        this.listener = listener;

        HashMap<String, String> parametros = new HashMap<>();
        parametros.put("ACTION", "RESTAURANTES.TOP10"); // TODO en netbeans server la consulta SQL

        TareaSegundoPlano hilo = new TareaSegundoPlano(parametros);
        hilo.execute(URL_SERVER);
    }


    /**
     * Asyntask
     */
    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros = null;

        public TareaSegundoPlano(HashMap<String, String> parametros) {
            super();
            this.parametros = parametros;
        }


        @Override
        protected Boolean doInBackground(String... strings) {

            String urlSeleccionada = strings[0];
            Post post = new Post();

            try {

                JSONArray listaTop10JSON = post.getServerDataPost(parametros, urlSeleccionada);

                listaTop10 = Restaurante.getArrayListFromJSON(listaTop10JSON);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }


        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaTop10 != null && listaTop10.size() > 0) {
                    listener.onCorrecto(listaTop10);
                } else {
                    listener.onError("Error al traer los datos del servidor");
                }
            }

        }
    }


}
