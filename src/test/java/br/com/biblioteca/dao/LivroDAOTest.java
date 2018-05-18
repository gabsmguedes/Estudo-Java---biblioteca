package br.com.biblioteca.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Livro;

public class LivroDAOTest {

	
	/*@Test
	public void testSqlInsertLivro() throws SQLException{
		
		Livro livro = new Livro();
		livro.setNome("teste");
		livro.getEditora().setId(2);
		livro.getAutor().setId(2);
		livro.setQuantidade(10);
		
		Connection connection = DataBase.getConexao();
		LivroDAO livroDAO = new LivroDAO(connection);
		
		livroDAO.Insert(livro);
	}
	
	@Test
	public void testSqlUpdateLivro() throws SQLException{
		
		Livro livro = new Livro();
		livro.setId(2);
		livro.setNome("Harry Potter e o Calice de Fogo");
		livro.getAutor().setId(2);;
		livro.getEditora().setId(2);
		livro.setQuantidade(3);
		
		Connection connection = DataBase.getConexao();
		LivroDAO livroDAO = new LivroDAO(connection);
		
		livroDAO.Update(livro);
	}*/
	
	@Test
	public void testSqlDeleteLivro() throws SQLException{
		
		Livro livro = new Livro();
		livro.setId(3);
		
		Connection connection = DataBase.getConexao();
		LivroDAO livroDAO = new LivroDAO(connection);
		
		livroDAO.Delete(livro);
	}
	
	@Test
	public void testSqlSelectLivro() throws SQLException {
		
		
		Connection connection = DataBase.getConexao();
		LivroDAO livroDAO = new LivroDAO(connection);
		List<Livro> livros = livroDAO.Select();
		
		for (Livro livro : livros) {
			System.out.println("ID do Livro: " + livro.getId());
			System.out.println("Nome do Livro: " + livro.getNome());
			System.out.println("ID da Editora: " + livro.getEditora().getId());
			System.out.println("Nome da Editora: " + livro.getEditora().getNome());
			System.out.println("ID do Autor: " + livro.getAutor().getId());
			System.out.println("Nome do Autor: " + livro.getAutor().getNome());
			System.out.println("Quantidade de Livros: " + livro.getQuantidade());
			System.out.println("-----------------------------------------");
		}
	}

}
