package br.com.biblioteca.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Autor;
import br.com.biblioteca.model.Editora;

public class AutorDAOTest {

	
	/*@Test
	public void testSqlInsertAutor() throws SQLException {
		
		Autor autor = new Autor();
		autor.setNome("teste");
		
		Connection connection = DataBase.getConexao();
		AutorDAO autorDAO = new AutorDAO(connection);
		
		autorDAO.Insert(autor);
	}*/
	
	/*@Test
	public void testSqlUpdateAutor() throws SQLException {
		
		Autor autor = new Autor();
		autor.setId(1);
		autor.setNome("Rick Riordan");
		
		Connection connection = DataBase.getConexao();
		AutorDAO autorDAO = new AutorDAO(connection);
		
		autorDAO.Update(autor);
	}*/
	
	@Test
	public void testSqlDeleteAutor() throws SQLException {
		
		Autor autor = new Autor();
		autor.setId(3);
		
		Connection connection = DataBase.getConexao();
		AutorDAO autorDAO = new AutorDAO(connection );
		
		autorDAO.Delete(autor);
	}
	
	@Test
	public void testSqlSelectAutor() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		AutorDAO autorDAO = new AutorDAO(connection);
		
		List<Autor> autores = autorDAO.Select();
		
		for (Autor autor : autores) {
			
			System.out.println("ID: " + autor.getId());
			System.out.println("Nome: " + autor.getNome());
		}
	}

}
