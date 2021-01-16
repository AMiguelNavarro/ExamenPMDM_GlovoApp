/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.controlador;

import com.svalero.glovoservlet.action.RestaurantesAction;
import com.svalero.glovoservlet.action.UsuariosAction;
import com.svalero.glovoservlet.action.ValoracionesAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {


    /**
     * Todas las peticiones que entren por get o por post vienen aquí
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Mediante action nos comunicamos con el server y le decimos que debe mostrarnos. ES NUESTRO PROPIO PROTOCOLO
        // Ejemplo ----> ?ACTION=RESTAURANTES.FINDALL 
        String action = request.getParameter("ACTION");
        String arrayAction[] = action.split("\\."); // Separa por punto. [0] tendra la parte RESTAURANTES ------ [1] se quedara con el FINDALL
        
        switch (arrayAction[0]) {
            
            // Restaurantes.FIND_ALL
            case "RESTAURANTES":
                //instancia el DAO correspondiente y hace la consulta SQL a la base de datos
                out.print(new RestaurantesAction().execute(request, response));
                break;
                
            case "USUARIOS":
                out.print(new UsuariosAction().execute(request, response));
                break;
                
            case "VALORACION":
                out.print(new ValoracionesAction().execute(request, response));
                break;              
                
            default:
                break;
                    
            
        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
