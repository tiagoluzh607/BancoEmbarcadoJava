/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoembarcado.dao;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tiago
 */
public class Banco {

    private final Connection connection;

    
    public Banco(Connection connection) {
        this.connection = connection;
    }
    
    
    public void CriaEstrutura() throws SQLException{
    
        String sql =    "CREATE TABLE IF NOT EXISTS produto (\n" +
                        "  id INTEGER IDENTITY PRIMARY KEY,\n" +
                        "  descricao VARCHAR(30)\n" +
                        ");";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }

}
