/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DAO.DestinoDAO;
import DAO.EncomendaDAO;
import DAO.PessoaDAO;
import entidades.Destino;
import entidades.Encomenda;
import entidades.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Main {
    
    public static void main(String args[]){
        /*Pessoa p = new Pessoa();
        p.setId(6);
        p.setNome("Joao");
        p.setSobrenome("Jose");
        
        PessoaDAO.inserir(p);
        
        List<Pessoa> pessoas = PessoaDAO.getPessoas();
        
        for(Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getId() + " - "+pessoa.getNome()+" - "+pessoa.getSobrenome());
        }*/
        
        /*Destino d = new Destino();
        d.setCidade("Natal");
        d.setCep("59000-000");
        
        Encomenda e = new Encomenda();
        e.setDescricao("Vários galados");
        e.setDestino(d);
        
        EncomendaDAO.inserir(e);*/
        
        Destino d = DestinoDAO.buscarDestino(2);
        List <Encomenda> encomendas = DestinoDAO.buscarEncomendas(d);
        
        for (Object encomenda : encomendas) {
            System.out.println(encomenda);
        }
    }
}
