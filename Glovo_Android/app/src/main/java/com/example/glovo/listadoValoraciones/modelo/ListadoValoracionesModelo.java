package com.example.glovo.listadoValoraciones.modelo;

import android.os.AsyncTask;

import com.example.glovo.beans.Valoracion;
import com.example.glovo.listadoValoraciones.interfaces.ListadoValoracionesContrato;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class ListadoValoracionesModelo implements ListadoValoracionesContrato.Modelo {

    private static final String URL_SERVER = "http://192.168.0.18:8080/GlovoServlet/Controlador";

    private ArrayList<Valoracion> listaValoraciones;
    private OnListenerValoracion listener;


    @Override
    public void getValoracionesWS(OnListenerValoracion listener) {

        this.listener = listener;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "VALORACION.FIND_ALL");

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute(URL_SERVER);

    }


    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros = null;

        public TareaSegundoPlano(HashMap<String, String> parametros) {
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            String url_seleccionada = strings[0];
            Post post = new Post();

            try {

                JSONArray listaValoracionesJSON = post.getServerDataPost(parametros, url_seleccionada);
                listaValoraciones = Valoracion.getArrayListFromJSON(listaValoracionesJSON);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaValoraciones != null && listaValoraciones.size() > 0) {
                    listener.onCorrecto(listaValoraciones);
                } else{
                    listener.onError("Error al traer los datos de las valoraciones");
                }
            }

        }
    }

}
