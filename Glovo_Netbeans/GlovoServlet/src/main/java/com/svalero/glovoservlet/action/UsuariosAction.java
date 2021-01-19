/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.action;

import com.svalero.glovoservlet.DAO.UsuariosDAO;
import com.svalero.glovoservlet.interfaces.Action;
import com.svalero.glovoservlet.modelos.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
public class UsuariosAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String cadenaDestino = "";
        String action = (String) request.getParameter("ACTION");
        String [] arrayAction = action.split("\\.");
        
        switch(arrayAction[1]) {
            
            case "FIND":
                cadenaDestino = validarUsuario(request, response);
                break;
            
        }
        
        return cadenaDestino;
    }
    
    public String validarUsuario(HttpServletRequest request, HttpServletResponse response){
        
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        
        String usuario = request.getParameter("USUARIO");
        String contrasena = request.getParameter("CONTRASENA");
        
        Usuario user = new Usuario();
        user.setUsuario(usuario);
        user.setPassword(contrasena);
        
        ArrayList<Usuario> listaUsuarios = usuariosDAO.validarUsuario(user);
        
        return Usuario.toArrayJSon(listaUsuarios);
        
    }
    
}
