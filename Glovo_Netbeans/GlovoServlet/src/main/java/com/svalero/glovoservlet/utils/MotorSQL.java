package com.svalero.glovoservlet.utils;


import com.svalero.glovoservlet.interfaces.IMotorSQL;
import java.sql.ResultSet;



public abstract class MotorSQL implements IMotorSQL  {

	public abstract void connect();

	public abstract int execute(String sql);

	public abstract ResultSet executeQuery(String sql);

	public abstract void disconnect();

}
