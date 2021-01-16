/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.action;

import com.svalero.glovoservlet.DAO.ValoracionesDAO;
import com.svalero.glovoservlet.interfaces.Action;
import com.svalero.glovoservlet.modelos.Valoracion;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
public class ValoracionesAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String cadenaDestino = "";
        String action = (String) request.getParameter("ACTION");
        String [] arrayAction = action.split("\\.");
        
        switch (arrayAction[1]) {
            
            case "FIND_ALL":
                cadenaDestino = findAll(request, response);
                break;
            
        }
        
        return cadenaDestino;
        
    }
    
    
    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        ValoracionesDAO valoracionesDAO = new ValoracionesDAO();
        ArrayList<Valoracion> listaValoraciones = valoracionesDAO.findAll();
        
        return Valoracion.toArrayJSon(listaValoraciones);
    }
    
}
