package br.com.biblioteca.bll;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.biblioteca.dao.AlunoDAO;
import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Aluno;

public class AlunoBLL {
	
	public List<Aluno> Select() throws SQLException{
		Connection connection = DataBase.getConexao();
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		return alunoDAO.Select();
	}

	public void Insert(Aluno aluno) throws SQLException{
		
		Connection connection = DataBase.getConexao();
		//String ra = aluno.getRa();
		if(aluno.getRa().length() < 10 || aluno.getRa().length() > 10){
			System.out.println("Ra não pode ser menor que 10 e nem maior que 10 ou vazio");
			return;
		}
		if(aluno.getNome().length() == 0){
			System.out.println("Nome não pode ser vazio");
			return;
		}
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		alunoDAO.Insert(aluno);
	}
	
	public void Update(Aluno aluno) throws SQLException{
		Connection connection = DataBase.getConexao();
		if(aluno.getRa().length() < 10 || aluno.getRa().length() > 10){
			System.out.println("Ra não pode ser menor que 10 e nem maior que 10 ou vazio");
			return;
		}
		if(aluno.getNome().length() == 0){
			System.out.println("Nome não pode ser vazio");
			return;
		}
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		alunoDAO.Update(aluno);
	}

	public void Delete(Aluno aluno) throws SQLException {
		Connection connection = DataBase.getConexao();
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		alunoDAO.Delete(aluno);
	}
}
