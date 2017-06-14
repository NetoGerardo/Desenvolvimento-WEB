/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class Banco {
    
    public static Connection con = null;

    public static Connection getConexao(){       
    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con =  DriverManager.getConnection ("jdbc:derby://localhost:1527/sample", "app", "app");
        } catch (ClassNotFoundException exc) {
            System.out.println("Error ao carregar o Driver");
        } catch (SQLException ex ) {
            System.out.println ("Problemas ao abrir a conexao com o banco");
        }
        return con;
    }
}
