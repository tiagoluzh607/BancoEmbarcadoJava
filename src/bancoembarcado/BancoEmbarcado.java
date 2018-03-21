/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoembarcado;

import bancoembarcado.connection.ConnectionPool;
import bancoembarcado.dao.Banco;
import bancoembarcado.dao.ProdutoDAO;
import bancoembarcado.model.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class BancoEmbarcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        
        try(Connection conexao = new ConnectionPool().getConnection()){ // usar a conexao sempre com try pois assim ele fecha automaticamente a conexao
        
            new Banco(conexao).CriaEstrutura(); //Cria Estrutura
        
            //Manipulando um produto no banco
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
            Produto produto1 = new Produto("Produto Teste1");
            Produto produto2 = new Produto("Produto Teste2");
            
            
            produtoDAO.Insert(produto1); // insere o produto no banco de dados
            produtoDAO.InsertOrUpdate(produto2); //insere ou atualiza o produto no banco depende se o objeto tem id ou nao
            
            ArrayList<Produto> todosOsProdutos = produtoDAO.lista(); //Traz todos os produtos do banco
            ExibeListaDeProdutos(todosOsProdutos); // Exibe na Tela todos os produtos do banco
            
        
        }           
        
    }
    
    //Recebe um lista de produtos e exibe na tela 
    private static void ExibeListaDeProdutos( ArrayList<Produto> produtos){
        
        for(Produto produto: produtos){
            System.err.println(produto.getId() + " - " + produto.getDescricao());
        }
    }
    
}
