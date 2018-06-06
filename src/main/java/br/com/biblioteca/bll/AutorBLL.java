package br.com.biblioteca.bll;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.biblioteca.dao.AutorDAO;
import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Autor;

public class AutorBLL {

	Connection connection = null;
	public AutorBLL(Connection connection) {
		this.connection = connection;
	}
	
	public List<Autor> Select() throws SQLException{
		AutorDAO autorDAO = new AutorDAO(connection);
		return autorDAO.Select();
		
	}
	
	public void Insert(Autor autor) throws SQLException{
		if(autor.getNome().isEmpty()){
			System.out.println("Nome não pode ser vazio!");
			return;
		}
		AutorDAO autorDAO = new AutorDAO(connection);
		autorDAO.Insert(autor);
	}
	
	public void Update(Autor autor) throws SQLException{
		if(autor.getNome().isEmpty()){
			System.out.println("Nome não pode ser vazio");
			return;
		}
		AutorDAO autorDAO = new AutorDAO(connection);
		autorDAO.Update(autor);
	}
	
	public void Delete(Autor autor) throws SQLException{
		AutorDAO autorDAO = new AutorDAO(connection);
		autorDAO.Delete(autor);
	}
}
