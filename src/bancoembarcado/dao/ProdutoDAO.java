/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoembarcado.dao;

import bancoembarcado.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void Insert(Produto produto) throws SQLException {
		
		String sql = "insert into produto (descricao) values (?)";
                PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, produto.getDescricao());
		
		statement.execute();
		
		//Retornando produto com id
                ResultSet resultSet = statement.getGeneratedKeys();
		
		resultSet.next();
		int id = resultSet.getInt("id");
		
		produto.setId(id);	
	}

	public void Update(Produto produto) throws SQLException {
		
		String sql = "update produto set descricao = ? where id = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, produto.getDescricao());
		statement.setInt(2, produto.getId());
		
		statement.execute();
	}
	
	public void InsertOrUpdate(Produto produto) throws SQLException {
		
		if(produto.getId() > 0) {
			Update(produto);
		}else {
			Insert(produto);
		}
	}
	
	public void Delete(Produto produto) throws SQLException {
		
		String sql = "delete from produto where id = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, produto.getId());
		
		statement.execute();
	}
	
	public ArrayList<Produto> lista() throws SQLException{
		
		String sql = "select * from produto";
		PreparedStatement statement = connection.prepareStatement(sql);
			
		return pesquisa(statement);
	}
	
	public ArrayList<Produto> listaPorUsuarioId(int usuarioid) throws SQLException{
		
		String sql = "select * from produto where usuarioid = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, usuarioid);
			
		return pesquisa(statement);
	}

	/**
         *  Recebe um Statement com um sql e retorna uma lista de objetos produtos 
         * @param statement
         * @return ArrayList<Produto>
         * @throws SQLException 
         */
	private ArrayList<Produto> pesquisa(PreparedStatement statement) throws SQLException {
		ArrayList<Produto> produtos = new ArrayList<>();
		
		boolean resultado = statement.execute();	
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String descricao = resultSet.getString("descricao");
			
			Produto produto = new Produto(id,descricao);
			
			produtos.add(produto);
		}	
		return produtos;
	}
	
	
}
