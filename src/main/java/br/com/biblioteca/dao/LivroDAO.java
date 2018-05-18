package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Livro;

public class LivroDAO {

	Connection connection = null;
	public LivroDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Livro> Select() throws SQLException{
		
		List<Livro> livros = new ArrayList<>();
		String sql = "SELECT l.id, l.nome as nome_livro, l.quantidade as quantidade_livro, "
				//+ "l.id_editora, l.id_autor, "
				+ "e.id as ideditora, e.nome as nome_editora, "
				+ "a.id as idautor, a.nome as nome_autor "
				+ "FROM livro l "
				+ "INNER JOIN editora e ON l.id_editora = e.id "
				+ "INNER JOIN autor a ON l.id_autor = a.id;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.executeQuery();
			try (ResultSet resultSet = preparedStatement.getResultSet()){
				while (resultSet.next()) {
					Livro livro = new Livro();
					livro.setId(resultSet.getInt("id"));
					livro.setNome(resultSet.getString("nome_livro"));
					livro.setQuantidade(resultSet.getInt("quantidade_livro"));
					livro.getEditora().setId(resultSet.getInt("ideditora"));
					livro.getEditora().setNome(resultSet.getString("nome_editora"));
					livro.getAutor().setId(resultSet.getInt("idautor"));
					livro.getAutor().setNome(resultSet.getString("nome_autor"));
					livros.add(livro);
				}
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.getMessage();
		}
		connection.close();
		return livros;
		 
	}
	
	public void Insert(Livro livro) throws SQLException{
		
		String sql = "insert into livro (nome, id_editora, id_autor, quantidade) values (?,?,?,?);";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, livro.getNome());
			preparedStatement.setInt(2, livro.getEditora().getId());
			preparedStatement.setInt(3, livro.getAutor().getId());
			preparedStatement.setInt(4, livro.getQuantidade());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
	
	public void Update(Livro livro) throws SQLException{
		
		String sql = "update livro set nome=?, id_editora=?, id_autor=?, quantidade=? where id=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, livro.getNome());
			preparedStatement.setInt(2, livro.getEditora().getId());
			preparedStatement.setInt(3, livro.getAutor().getId());
			preparedStatement.setInt(4, livro.getQuantidade());
			preparedStatement.setInt(5, livro.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
	
	public void Delete(Livro livro) throws SQLException{
		
		String sql = "delete from livro where id=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, livro.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
}
