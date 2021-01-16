/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.DAO;

import com.svalero.glovoservlet.modelos.Valoracion;
import com.svalero.glovoservlet.utils.ConnectionFactory;
import com.svalero.glovoservlet.utils.MotorSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class ValoracionesDAO {
    
    private MotorSQL motorSQL;
    
    private final String SQL_FINDALL = "select restaurantes.nombre, AVG(valoraciones.puntuacion) as puntuacion, restaurantes.imagen from valoraciones INNER JOIN restaurantes on restaurantes.idRestaurante = valoraciones.idRestaurante GROUP BY restaurantes.nombre";
    
    
    public ValoracionesDAO() {
        motorSQL = ConnectionFactory.selectDb();
    }
    
    public ArrayList<Valoracion> findAll() {
        
        ArrayList<Valoracion> listaValoraciones = new ArrayList<>();
        
        try {
            
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery(SQL_FINDALL);
            
            while(rs.next()) {
                Valoracion valoracion = new Valoracion();
                
                valoracion.setNombre(rs.getString(1));
                valoracion.setPuntuacion(rs.getInt(2));
                valoracion.setImagen(rs.getString(3));
                
                listaValoraciones.add(valoracion);
                
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            motorSQL.disconnect();
        }
        
        return listaValoraciones;
        
    }
}
