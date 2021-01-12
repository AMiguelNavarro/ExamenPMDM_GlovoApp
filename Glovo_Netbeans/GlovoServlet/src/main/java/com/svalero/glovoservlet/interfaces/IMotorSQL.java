/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svalero.glovoservlet.interfaces;

import java.sql.ResultSet;

/**
 *
 * @author Diego Abad
 */
public interface IMotorSQL {
	
	public void connect();
	public int execute(String sql);
	public ResultSet executeQuery(String sql);
	public void disconnect();

}
