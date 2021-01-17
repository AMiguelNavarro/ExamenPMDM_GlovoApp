/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.DAO;

import com.svalero.glovoservlet.modelos.Menu;
import com.svalero.glovoservlet.utils.ConnectionFactory;
import com.svalero.glovoservlet.utils.MotorSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class MenusDAO {
    
    private final String SQL_FIND = "SELECT * FROM menus WHERE idRestaurante = ";
    
    private MotorSQL motorSQL;
    
    public MenusDAO() {
        motorSQL = ConnectionFactory.selectDb();
    }
    
    public ArrayList<Menu> findMenus(int idRestaurante) {
        
        ArrayList<Menu> listaMenus = new ArrayList<>();
        String sql = SQL_FIND + idRestaurante;
        
        try {
            
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(sql);
            
            while(rs.next()){
                
                Menu menu = new Menu();
                
                menu.setPrimero(rs.getString(3));
                menu.setSegundo(rs.getString(4));
                menu.setPostre(rs.getString(5));
                menu.setPrecio(rs.getDouble(6));
                menu.setNombreMenu(rs.getString(7));
                menu.setImagenMenu(rs.getString(8));
                menu.setBebida(rs.getString(9));
                
                listaMenus.add(menu);
                
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return listaMenus;
                     
    }
    
}
