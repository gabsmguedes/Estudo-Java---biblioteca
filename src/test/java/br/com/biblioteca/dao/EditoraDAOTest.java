package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Editora;

public class EditoraDAOTest {

	@Test
	public void testSqlSelectEditora() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		List<Editora> editoras = editoraDAO.Select();
		
		for (Editora editora : editoras) {
			System.out.println("ID: " + editora.getId());
			System.out.println("Nome: " + editora.getNome());
		}
	}

	
	@Test
	public void testSqlInsertEditora() throws Exception {
		
		Editora editora = new Editora();
		//editora.setNome("teste");
		
		//Connection connection = DataBase.getConexao();
		//EditoraDAO editoraDAO = new EditoraDAO(connection);
		
		//editoraDAO.Insert(editora);
		
	}
	
	@Test
	public void testSqlUpdateEditora() throws Exception {
		
		Editora editora = new Editora();
		//editora.setId(1);
		//editora.setNome("Intrinseca");
		
		Connection connection = DataBase.getConexao();
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		
		//editoraDAO.Update(editora);
	}
	
	@Test
	public void testSqlDeleteEditora() throws Exception {
		
		Editora editora = new Editora();
		editora.setId(5);
		
		Connection connection = DataBase.getConexao();
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		
		editoraDAO.Delete(editora);
	}
}
