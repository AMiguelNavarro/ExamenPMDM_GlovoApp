package com.svalero.glovoservlet.DAO;

import com.svalero.glovoservlet.modelos.Usuario;
import com.svalero.glovoservlet.utils.ConnectionFactory;
import com.svalero.glovoservlet.utils.MotorSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UsuariosDAO {
    
    private MotorSQL motorSQL;
    private final String SQL_VALIDAR_USUARIO = "SELECT * FROM usuarios WHERE 1=1 ";
    
    public UsuariosDAO(){
        motorSQL = ConnectionFactory.selectDb();
    }
    
    public ArrayList<Usuario> validarUsuario(Usuario beanUsuario) {
        
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        String sql = SQL_VALIDAR_USUARIO;
        
        try {
            motorSQL.connect();
            
            if (beanUsuario != null) {
                if(beanUsuario.getUsuario() != null){
                    sql += "AND usuario = '" + beanUsuario.getUsuario() + "'";
                }
                
                if(beanUsuario.getPassword() != null){
                    sql += "AND password = '" + beanUsuario.getPassword() + "'";
                }
            }
            
            ResultSet rs = motorSQL.executeQuery(sql);
            
            while(rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setUsuario(rs.getString(5));
                usuario.setPassword(rs.getString(6));
                
                listaUsuario.add(usuario);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motorSQL.disconnect();
        }
        
        return listaUsuario;
        
    }
    
}
