package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.model.Autor;

public class AutorDAO {

	Connection connection = null;

	public AutorDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Autor> Select() throws SQLException {

		List<Autor> autores = new ArrayList<>();
		String sql = "select id, nome from autor;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.executeQuery();
			try (ResultSet resultSet = preparedStatement.getResultSet()) {

				while (resultSet.next()) {
					Autor autor = new Autor();
					autor.setId(resultSet.getInt("id"));
					autor.setNome(resultSet.getString("nome"));
					autores.add(autor);
					
				}
				resultSet.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
		return autores;

	}
	
	public void Insert(Autor autor) throws SQLException{
		
		String sql = "insert into autor (nome) values (?);";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, autor.getNome());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
	
	public void Update(Autor autor) throws SQLException{
		
		String sql = "update autor set nome=? where id=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, autor.getNome());
			preparedStatement.setInt(2, autor.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
	
	public void Delete(Autor autor) throws SQLException{
		
		String sql = "delete from autor where id=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, autor.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
}
