/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.action;

import com.svalero.glovoservlet.DAO.MenusDAO;
import com.svalero.glovoservlet.interfaces.Action;
import com.svalero.glovoservlet.modelos.Menu;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
public class MenusAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            
        String cadenaDestino = "";
        String action = (String) request.getParameter("ACTION");
        String [] arrayAction = action.split("\\.");
        
        switch (arrayAction[1]) {
            
            case "FIND":
                cadenaDestino = find(request, response);
                break;
               
            
        }
        
        return cadenaDestino;
              
    }
    
    
    public String find(HttpServletRequest request, HttpServletResponse response) {
        MenusDAO menusDAO = new MenusDAO();
        int idRestaurante = Integer.parseInt(request.getParameter("ID_RESTAURANTE"));
        
        ArrayList<Menu> listaMenus = menusDAO.findMenus(idRestaurante);
    
        return Menu.toArrayJSon(listaMenus);
    }
    
}
