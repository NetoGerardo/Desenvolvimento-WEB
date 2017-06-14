/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Encomenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class EncomendaDAO {
    
    public static int inserir(Encomenda encomenda){
        
        Connection con = Banco.getConexao();        
        String inserirDestino = "INSERT INTO Encomenda(\"descricao\", \"idDestino\") VALUES (?,?)";
        int i =0;
        try {
            PreparedStatement stmt = con.prepareStatement(inserirDestino);
            stmt.setString(1, encomenda.getDescricao());
            stmt.setInt(2, DestinoDAO.inserir(encomenda.getDestino()));
            i = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return i;
    }
    
    
    
}
