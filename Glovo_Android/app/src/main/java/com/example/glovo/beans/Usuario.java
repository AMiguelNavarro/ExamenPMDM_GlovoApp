package com.example.glovo.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    private static final String USUARIO = "usuario";
    private static final String CONTRASENA = "password";
    private static final String NOMBRE = "nombre";
    private static final String APELLIDO = "apellido";
    private static final String EMAIL = "email";
    private static final String ID_USUARIO = "idUsuario";

    private String usuario, contrasena, nombre, apellido, email;
    private int idUsuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }



    public static ArrayList<Usuario> getArrayListFromJSON(JSONArray listaUsuario) {
        ArrayList<Usuario> lstUsuario = null;
        try {
            if (listaUsuario != null && listaUsuario.length() > 0) {
                lstUsuario = new ArrayList<Usuario>();
            }

            // Se recorre la lista que llega por parámetro y se mete en un objeto Restaurante
            for (int i = 0; i < listaUsuario.length(); i++) {
                JSONObject json_data = listaUsuario.getJSONObject(i);
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(json_data.getInt(ID_USUARIO));
                usuario.setNombre(json_data.getString(NOMBRE));
                usuario.setApellido(json_data.getString(APELLIDO));
                usuario.setUsuario(json_data.getString(USUARIO));
                usuario.setContrasena(json_data.getString(CONTRASENA));
                usuario.setEmail(json_data.getString(EMAIL));

                lstUsuario.add(usuario);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lstUsuario;
    }
}
