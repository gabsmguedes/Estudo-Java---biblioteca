package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Editora;

public class EditoraDAO {

	private Connection connection = null;

	public EditoraDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Editora> Select() throws SQLException {

		// Connection connection = DataBase.getConexao();
		List<Editora> editoras = new ArrayList<>();
		String sql = "select id, nome from editora;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.executeQuery();
			try (ResultSet resultSet = preparedStatement.getResultSet()) {

				while (resultSet.next()) {
					Editora editora = new Editora();
					editora.setId(resultSet.getInt("id"));
					editora.setNome(resultSet.getString("nome"));
					editoras.add(editora);
				}
				resultSet.close();
			} catch (Exception e) {
				e.getMessage();
			}

			preparedStatement.close();
		} catch (Exception e) {
			e.getMessage();
		}

		connection.close();
		return editoras;

	}

	public void Insert(Editora editora) throws SQLException {

		String sql = "insert into editora (nome) values (?);";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, editora.getNome());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		connection.close();
	}
	
	public void Update(Editora editora) throws SQLException{
		
		String sql = "update editora set nome=? where id=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			
			preparedStatement.setString(1, editora.getNome());
			preparedStatement.setInt(2, editora.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
	
	public void Delete(Editora editora) throws SQLException{
		
		String sql = "delete from editora where id=?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			
			preparedStatement.setInt(1, editora.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
}
