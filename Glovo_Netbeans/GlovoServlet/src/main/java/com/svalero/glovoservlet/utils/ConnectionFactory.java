package com.svalero.glovoservlet.utils;


/**
 * Se realiza así ya que si en algún momento se quisiese cambiar de SGBD sería mucho más fácil
 * para este proyecto por defecto MYSQL
 * @author alber
 */
public class ConnectionFactory {
    
        public static final int db = 2;
	public static final int ORACLE_DB = 1;
	public static final int MYSQL_DB = 2;

	public static MotorSQL selectDb() {
            MotorSQL motorSQL=null;
            switch(db){
                case MYSQL_DB:
                    motorSQL = new MotorMySQL();
                    break;
                case ORACLE_DB:
                    // habría que crear la clase motorOracle 
                    //motorSQL = "MotorOracle"
                    motorSQL = null;
                    break;
            }
            return motorSQL;
	}
}
