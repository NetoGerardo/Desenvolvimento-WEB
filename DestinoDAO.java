/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Destino;
import entidades.Encomenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class DestinoDAO {
 
    public static int inserir(Destino destino){
        
        Connection con = Banco.getConexao();        
        String inserirDestino = "INSERT INTO Destino(\"cidade\", \"cep\") VALUES (?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(inserirDestino, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, destino.getCidade());
            stmt.setString(2, destino.getCep());
            stmt.executeUpdate();
            ResultSet rs =  stmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return -1;
    }
    
    public static Destino buscarDestino(int id){
        Connection con = Banco.getConexao();        
        String buscarDestino = "SELECT * FROM Destino WHERE \"id\" = "+id;
        Destino d = new Destino();;
        try {
            PreparedStatement stmt = con.prepareStatement(buscarDestino);        
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                d.setId(rs.getInt(1));
                d.setCidade(rs.getString(2));
                d.setCep(rs.getString(3));
            }
            
            return d;
                  
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static List<Encomenda> buscarEncomendas(Destino d){
        Connection con = Banco.getConexao();        
        String buscarDestino = "SELECT * FROM Encomenda WHERE \"idDestino\" = "+d.getId();
        ArrayList <Encomenda> encomendas = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(buscarDestino);        
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Encomenda e = new Encomenda();
                e.setId(rs.getInt(1));
                e.setDescricao(rs.getString(2));
                e.setDestino(d);
                encomendas.add(e);            
            }
            
            return encomendas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }  
   
}
