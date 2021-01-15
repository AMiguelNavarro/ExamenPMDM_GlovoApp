/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.DAO;

import com.svalero.glovoservlet.interfaces.IDAO;
import com.svalero.glovoservlet.modelos.Categoria;
import com.svalero.glovoservlet.utils.ConnectionFactory;
import com.svalero.glovoservlet.utils.MotorSQL;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class CategoriasDAO{
    
    private MotorSQL motorSql;
    
    private final String SQL_FINDALL = "SELECT * FROM categorias WHERE 1=1 AND categoria ='";
    
    
    public CategoriasDAO() {
        motorSql = ConnectionFactory.selectDb();
    }
    

    public int findAll(Categoria categoria) {
        String sql = SQL_FINDALL + categoria.getCategoria() + "'";
        int idCategoria = 0;
        
        try {
            
            motorSql.connect();
            
            ResultSet rs = motorSql.executeQuery(sql);
            
            while(rs.next()) {
                idCategoria = rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return idCategoria;
    }



    
}
