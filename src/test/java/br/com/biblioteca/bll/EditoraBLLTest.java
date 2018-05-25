package br.com.biblioteca.bll;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Editora;

public class EditoraBLLTest {

	@Test
	public void testBLLSelectEditora() throws SQLException {
		Connection connection = DataBase.getConexao();
		EditoraBLL editoraBLL = new EditoraBLL(connection);
		List<Editora> editoras = editoraBLL.Select();
		
		for (Editora editora : editoras) {
			System.out.println("ID: " + editora.getId());
			System.out.println("Nome: " + editora.getNome());
		}
		
		System.out.println("ENCERRA TESTE SELECT");
	}
	
	@Test
	public void testBLLInsertEditoraComNomeVazio() throws SQLException{
		Connection connection = DataBase.getConexao();
		Editora editora = new Editora();
		editora.setNome("");
		EditoraBLL editoraBLL = new EditoraBLL(connection);
		editoraBLL.Insert(editora);
		System.out.println("ENCERRA TESTE INSERT COM NOME VAZIO");
	}
	
	//@Test
	public void testBLLInsertEditoraComNome() throws SQLException{
		Connection connection = DataBase.getConexao();
		Editora editora = new Editora();
		editora.setNome("teste delete");
		EditoraBLL editoraBLL = new EditoraBLL(connection);
		editoraBLL.Insert(editora);
		System.out.println("ENCERRA TESTE INSERT COM NOME");
	}
	
	@Test
	public void testBLLUpdateEditoraComNomeVazio() throws SQLException {
		Connection connection = DataBase.getConexao();
		Editora editora = new Editora();
		editora.setId(6);
		editora.setNome("");
		EditoraBLL editoraBLL = new EditoraBLL(connection);
		editoraBLL.Update(editora);
		System.out.println("ENCERRA TESTE UPDATE COM NOME VAZIO");
	}
	
	@Test
	public void testBLLUpdateEditoraComNome() throws SQLException {
		Connection connection = DataBase.getConexao();
		Editora editora = new Editora();
		editora.setId(6);
		editora.setNome("Reed Elsevier");
		EditoraBLL editoraBLL = new EditoraBLL(connection);
		editoraBLL.Update(editora);
		System.out.println("ENCERRA TESTE UPDATE COM NOME VAZIO");
	}
	
	@Test
	public void testBLLDeleteEditora() throws SQLException {
		Connection connection = DataBase.getConexao();
		Editora editora = new Editora();
		editora.setId(8);
		EditoraBLL editoraBLL = new EditoraBLL(connection);
		editoraBLL.Delete(editora);
		System.out.println("ENCERRA TEST DELETE");
	}
	
}
