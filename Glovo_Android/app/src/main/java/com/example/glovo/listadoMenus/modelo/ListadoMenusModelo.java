package com.example.glovo.listadoMenus.modelo;

import android.os.AsyncTask;

import com.example.glovo.beans.Menu;
import com.example.glovo.listadoMenus.interfaces.ListadoMenusContrato;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class ListadoMenusModelo implements ListadoMenusContrato.Modelo {

    private static final String URL_SERVER = "http://192.168.0.18:8080/GlovoServlet/Controlador";
    private ArrayList<Menu> listaMenus;
    private OnMenusListener listener;


    @Override
    public void getMenusWS(OnMenusListener listener, int idRestaurante) {

        this.listener = listener;
        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "MENU.FIND");
        param.put("ID_RESTAURANTE", String.valueOf(idRestaurante));

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute(URL_SERVER);

    }


    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros;

        public TareaSegundoPlano(HashMap<String, String> parametros) {
            super();
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            String url_seleccionada = strings[0];
            Post post = new Post();

            try {
                JSONArray listaMenusJSON = post.getServerDataPost(parametros, url_seleccionada);
                listaMenus = Menu.getArrayListFromJSON(listaMenusJSON);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;

        }

        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaMenus != null && listaMenus.size() > 0) {
                    listener.onCorrecto(listaMenus);
                } else{
                    listener.onError("Error al ver los menus");
                }
            }

        }
    }


}
