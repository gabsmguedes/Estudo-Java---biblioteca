package br.com.biblioteca.bll;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.biblioteca.dao.EditoraDAO;
import br.com.biblioteca.model.Editora;

public class EditoraBLL {

	Connection connection = null;
	public EditoraBLL(Connection connection) {
		this.connection = connection;
	}
	
	public List<Editora> Select() throws SQLException{
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		return editoraDAO.Select();
	}
	
	public void Insert(Editora editora) throws SQLException{
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		if(editora.getNome().isEmpty()) {
			System.out.println("Nome não pode ser vazio");
			return;
		}
		editoraDAO.Insert(editora);
	}
	
	public void Update(Editora editora) throws SQLException{
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		if(editora.getNome().isEmpty()) {
			System.out.println("Nome não pode ser vazio");
			return;
		}
		editoraDAO.Update(editora);
	}
	
	
	public void Delete(Editora editora) throws SQLException{
		EditoraDAO editoraDAO = new EditoraDAO(connection);
		editoraDAO.Delete(editora);
	}
}
