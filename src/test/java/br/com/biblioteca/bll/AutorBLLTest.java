package br.com.biblioteca.bll;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.dao.AutorDAO;
import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Autor;

public class AutorBLLTest {

	@Test
	public void testBLLSelectAutor() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		AutorBLL autorBLL = new AutorBLL(connection);
		List<Autor> autores = autorBLL.Select();
		
		for (Autor autor : autores) {
			System.out.println("ID: " + autor.getId());
			System.out.println("Nome: " + autor.getNome());
		}
		System.out.println("TESTE SELECT");
	}

	@Test
	public void testBLLInsertAutorComNomeVazio() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		Autor autor = new Autor();
		autor.setNome("");
		AutorBLL autorBLL = new AutorBLL(connection);
		autorBLL.Insert(autor);
		System.out.println("TESTE INSERT COM NOME VAZIO");
	}
	
	//@Test
	public void testBLLInsertAutorComNome() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		Autor autor = new Autor();
		autor.setNome("teste para update");
		AutorBLL autorBLL = new AutorBLL(connection);
		autorBLL.Insert(autor);
		System.out.println("TESTE INSERT COM NOME");
	}
	
	@Test
	public void testBLLUpdateAutorComNomeVazio() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		Autor autor = new Autor();
		autor.setId(3);
		autor.setNome("");
		AutorBLL autorBLL = new AutorBLL(connection);
		autorBLL.Update(autor);
		System.out.println("TESTE UPDATE COM NOME VAZIO");
	}
	
	@Test
	public void testBLLUpdateAutorComNome() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		Autor autor = new Autor();
		autor.setId(3);
		autor.setNome("teste para delete");
		AutorBLL autorBLL = new AutorBLL(connection);
		autorBLL.Update(autor);
		System.out.println("TESTE UPDATE COM NOME");
	}
	
	@Test
	public void testBLLDeleteAutor() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		Autor autor = new Autor();
		autor.setId(3);
		AutorBLL autorBLL = new AutorBLL(connection);
		autorBLL.Delete(autor);
		System.out.println("TESTE DELETE AUTOR");
	}
}
