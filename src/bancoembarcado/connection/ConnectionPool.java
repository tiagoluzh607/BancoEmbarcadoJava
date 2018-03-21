/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoembarcado.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

/**
 *
 * @author tiago
 */
public class ConnectionPool {
	
	public ConnectionPool(){

	}

	public Connection getConnection() throws SQLException {
		//Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		
		//cria um arquivo de banco de dados novo no caminho especificado, se usar o driver visual passar a mesma string de conexao
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql:/bancoteste", "SA", "");
		
		return connection;
	}
        
}

