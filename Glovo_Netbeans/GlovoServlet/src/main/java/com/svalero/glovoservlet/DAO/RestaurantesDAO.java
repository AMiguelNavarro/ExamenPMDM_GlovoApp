package com.svalero.glovoservlet.DAO;

import com.svalero.glovoservlet.interfaces.IDAO;
import com.svalero.glovoservlet.modelos.Restaurante;
import com.svalero.glovoservlet.utils.ConnectionFactory;
import com.svalero.glovoservlet.utils.MotorSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class RestaurantesDAO implements IDAO<Restaurante, Integer> {
    
    /* CONSULTAS SQL */
    private final String SQL_FINDALL = "SELECT * FROM restaurantes WHERE 1=1 ";
    private final String SQL_ADD = "INSERT INTO restaurantes (Nombre, Imagen, Descripcion, NumVentas) VALUES ";
    private final String SQL_DELETE = "DELETE FROM restaurantes WHERE idRestaurante=";
    private final String SQL_UPDATE = "UPDATE restaurantes SET ";
    
    private MotorSQL motorSql;

    public RestaurantesDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Restaurante> findAll(Restaurante beanRestaurante) {
        ArrayList<Restaurante> lstRestaurantes = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            
            if (beanRestaurante != null) {
                if (beanRestaurante.getIdRestaurante()!= 0) {
                    sql += "AND idRestaurante='" + beanRestaurante.getIdRestaurante() + "'";
                }
                
                if (beanRestaurante.getIdCategoria()!= 0) {
                    sql += "AND idCategoria='" + beanRestaurante.getIdCategoria()+ "'";
                }
                
                if (beanRestaurante.getNombre()!= null) {
                    sql += "AND Nombre='" + beanRestaurante.getNombre()+ "'";
                }
                
                if (beanRestaurante.getNumVentas()!= 0) {
                    sql += "AND NumVentas='" + beanRestaurante.getNumVentas()+ "'";
                }
                
                
                if (beanRestaurante.getDescripcion()!= null) {
                    sql += "AND Descripcion='" + beanRestaurante.getDescripcion()+ "'";
                }

                if (beanRestaurante.getImagen()!= null) {
                    sql += "AND Imagen='" + beanRestaurante.getImagen()+ "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            // Se recorre el resulset y se setean los datos en un objeto "restaurante" par aposteriormente añadirlo al arrayList
            while (rs.next()) {
                Restaurante restaurante = new Restaurante();

                restaurante.setIdRestaurante(rs.getInt(1));
                restaurante.setIdCategoria(rs.getInt(2));
                restaurante.setNombre(rs.getString(3));
                restaurante.setImagen(rs.getString(4));
                restaurante.setDescripcion(rs.getString(5));
                restaurante.setNumVentas(rs.getInt(6));

                lstRestaurantes.add(restaurante);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return lstRestaurantes;
    }

    @Override
    public int add(Restaurante bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getNombre()+ "', '"
                    + bean.getImagen()+ "', '"
                    + bean.getDescripcion()+ "', '"
                    + bean.getNumVentas()+ "', '";

            resp = motorSql.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Película insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id) {
        int resp = 0;
        motorSql.connect();
        try {
            String sql = SQL_DELETE + id;
            //desactivo la restriccion de claves foráneas para borrado
            motorSql.execute("SET FOREIGN_KEY_CHECKS=0;");
            resp = motorSql.execute(sql);
            //vuelvo a activar la restricción de claves foráneas
            motorSql.execute("SET FOREIGN_KEY_CHECKS=1;");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Borrado con exito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public int update(Restaurante bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getNombre()!= null) {
                    sql += "Nombre='" + bean.getNombre()+ "'";
                }

                if (bean.getImagen()!= null) {
                    sql += "Imagen='" + bean.getImagen()+ "'";
                }

                if (bean.getDescripcion() != null) {
                    sql += "Descripcion='" + bean.getDescripcion()+ "'";
                }

                if (bean.getNumVentas() > 0) {
                    sql += "NumVentas='" + bean.getNumVentas()+ "'";
                }

                sql += " WHERE `ID_Pelicula`=" + bean.getIdRestaurante()+ ";";
                System.out.println(sql);
                resp = motorSql.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorSql.disconnect();
        }

        if (resp > 0) {
            System.out.println("Pelicula actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }

    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        RestaurantesDAO peliculaDAO = new RestaurantesDAO();
        
        //Findall - filtra segun campos que no son null o 0
//        ArrayList lstPeliculas
//                = peliculaDAO.findAll(new Pelicula("Interstellar", null, null, null, 0, 500, 0, 0, null, null));
//        System.out.println(lstPeliculas.toString());
//
//        Pelicula peliprueba = new Pelicula("Joshua y los teleñecos", "www", "abc", "2015", 90, 5, 6, 9, 5.3, null);

//        //Add de registro
       // peliculaDAO.add(peliprueba);

//        //Update del registro con id pelicula 1
   //     peliculaDAO.update(new Pelicula("Titulo cambiado", null, null, null, 0, 0, 0, 1, null));

//        //Delete del registro 2
   //     peliculaDAO.delete(2);
    }
}
