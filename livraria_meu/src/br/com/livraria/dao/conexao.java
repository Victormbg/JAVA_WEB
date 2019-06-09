package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    private Connection con;
    
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                         .getConnection("jdbc:mysql://localhost:3306/livraria",
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