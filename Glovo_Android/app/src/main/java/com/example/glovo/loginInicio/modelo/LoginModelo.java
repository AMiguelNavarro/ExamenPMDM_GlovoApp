package com.example.glovo.loginInicio.modelo;

import android.os.AsyncTask;

import com.example.glovo.beans.Usuario;
import com.example.glovo.loginInicio.interfaces.LoginInterfazContrato;
import com.example.glovo.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginModelo implements LoginInterfazContrato.Modelo {

    private static final String URL_SERVER = "http://192.168.0.18:8080/GlovoServlet/Controlador";
    private OnLoginListener listener;
    private boolean validacion;
    private ArrayList<Usuario> listaUsuarios;


    @Override
    public void validarUsuarioWS(OnLoginListener listener, String usuario, String contrasena) {

        this.listener = listener;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "USUARIOS.FIND");
        param.put("USUARIO", usuario);
        param.put("CONTRASENA", contrasena);

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute(URL_SERVER);

    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros;

        public TareaSegundoPlano(HashMap<String, String> parametros) {
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            String url_seleccionada = strings[0];
            Post post = new Post();
            boolean correcto;

            try {
                JSONArray listaUsuariosJSON = post.getServerDataPost(parametros, url_seleccionada);
                listaUsuarios = Usuario.getArrayListFromJSON(listaUsuariosJSON);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (listaUsuarios != null) {
                correcto = true;
            } else {
                correcto = false;
            }


            return correcto;
        }

        @Override
        protected void onPostExecute(Boolean correcto) {

            if (correcto) {
                listener.onUsuarioCorrecto(listaUsuarios);
            } else {
                listener.onUsuarioIncorrecto("Usuario incorrecto");
            }

        }
    }

}
