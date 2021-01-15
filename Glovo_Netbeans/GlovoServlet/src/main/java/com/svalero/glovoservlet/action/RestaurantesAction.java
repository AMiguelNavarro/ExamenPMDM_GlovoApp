/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.action;

import com.svalero.glovoservlet.DAO.CategoriasDAO;
import com.svalero.glovoservlet.interfaces.Action;
import com.svalero.glovoservlet.DAO.RestaurantesDAO;
import com.svalero.glovoservlet.modelos.Categoria;
import com.svalero.glovoservlet.modelos.Restaurante;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
public class RestaurantesAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       
        String cadenaDestino = "";
        String action = (String) request.getParameter("ACTION");
        String [] arrayAction = action.split("\\.");
        
        switch (arrayAction[1]){
            
            case "FIND_ALL":
                cadenaDestino = findAll(request, response);
                break;
                
            case "CATEGORIA":
                cadenaDestino = filtroCategoria(request, response);
                break;
               
            case "TOP10":
                cadenaDestino = findTop10(request, response);
                break;
            
        }               
        
        return cadenaDestino;
        
    }
    
    
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        
        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();            
        ArrayList<Restaurante> listaRestaurantes = restaurantesDAO.findAll(null);
        
        return Restaurante.toArrayJSon(listaRestaurantes);
    }        
    
    
    public String filtroCategoria(HttpServletRequest request, HttpServletResponse response){
        
        
        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        Categoria categoria = new Categoria();
        Restaurante restaurante = new Restaurante();
        
        String nombreCategoria = request.getParameter("CATEGORIA");
        categoria.setCategoria(nombreCategoria);
        
        int idCategoria = categoriasDAO.findAll(categoria);
        restaurante.setIdCategoria(idCategoria);
        
        ArrayList<Restaurante> listaRestaurantes = restaurantesDAO.findAll(restaurante);
        
        return Restaurante.toArrayJSon(listaRestaurantes);

    }    
    
    public String findTop10(HttpServletRequest request, HttpServletResponse response){
        
        RestaurantesDAO restaurantesDAO = new RestaurantesDAO();
        ArrayList<Restaurante> listaTop10 = restaurantesDAO.findTop10();
        
        return Restaurante.toArrayJSon(listaTop10);
    }
}
