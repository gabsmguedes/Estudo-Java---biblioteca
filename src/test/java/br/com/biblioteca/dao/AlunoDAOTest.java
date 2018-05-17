package br.com.biblioteca.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Aluno;

public class AlunoDAOTest {

	
	/*@Test
	public void testSqlInsertAluno () throws SQLException {
		
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("1");
		aluno.setNome("teste");
		
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		alunoDAO.Insert(aluno);
	}*/
	
	/*@Test
	public void testSqlUpdateAluno() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("1421450077");
		aluno.setNome("Jandira Moura");
		
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		alunoDAO.Update(aluno);
	}*/
	
	@Test
	public void testSqlDeleteAluno() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("1");
		
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		alunoDAO.Delete(aluno);
	}
	
	@Test
	public void testSqlSelectAluno() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		AlunoDAO alunoDAO = new AlunoDAO(connection);
		
		List<Aluno> alunos = alunoDAO.Select();
		
		for (Aluno aluno : alunos) {
			System.out.println("RA: " + aluno.getRa());
			System.out.println("Nome: " + aluno.getNome());
		}
	}

}
