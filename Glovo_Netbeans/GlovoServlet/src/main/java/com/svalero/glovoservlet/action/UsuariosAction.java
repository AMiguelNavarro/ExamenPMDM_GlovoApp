/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.action;

import com.svalero.glovoservlet.interfaces.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
public class UsuariosAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "HOLA";
    }
    
}
