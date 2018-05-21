package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.model.Aluno;

public class AlunoDAO {

	Connection connection = null;

	public AlunoDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Aluno> Select() throws SQLException {

		List<Aluno> alunos = new ArrayList<>();
		String sql = "select ra, nome from aluno;";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.executeQuery();

			try (ResultSet resultSet = preparedStatement.getResultSet()) {
				while(resultSet.next()){
					Aluno aluno = new Aluno();
					aluno.setRa(resultSet.getString("ra"));
					aluno.setNome(resultSet.getString("nome"));
					alunos.add(aluno);
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
		return alunos;

	}
	
	public void Insert(Aluno aluno) throws SQLException{
		
		String sql = "insert into aluno (ra, nome) values(?,?);";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, aluno.getRa());
			preparedStatement.setString(2, aluno.getNome());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
	
	public void Update(Aluno aluno) throws SQLException{
		 
		String sql = "update aluno set nome=? where ra=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setString(2, aluno.getRa());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
	
	public void Delete(Aluno aluno) throws SQLException{
		
		String sql = "delete from aluno where ra=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, aluno.getRa());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		connection.close();
	}
}
