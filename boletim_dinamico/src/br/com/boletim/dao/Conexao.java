package br.com.boletim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection con;
    
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/boletim",
                                        "root",
                                        "");
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        }
        
        return con;
    }
    
    public void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
	        ex.printStackTrace();
        }
    }

}
