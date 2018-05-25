package br.com.biblioteca.bll;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.dao.AlunoDAO;
import br.com.biblioteca.dao.AlunoDAOTest;
import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Aluno;

public class AlunoBLLTest {

	@Test
	public void testBllSqlSelect() throws SQLException {
		Connection connection = DataBase.getConexao();
		AlunoBLL alunoBLL = new AlunoBLL(connection );
		List<Aluno> alunos = alunoBLL.Select();
		for (Aluno aluno : alunos) {
			System.out.println("RA: " + aluno.getRa());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("------------------------------------------");
			System.out.println("Teste Select");
		}
	}

	/*@Test
	public void testBllSqlInsertRaAlunoComValorMenorQueDez() throws SQLException {
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("-1");
		aluno.setNome("testando bll");

		AlunoBLL alunoBLL = new AlunoBLL(connection);
		alunoBLL.Insert(aluno);
		System.out.println("Teste Insert");
	}*/

	/*@Test
	public void testBllSqlInsertRaAlunoComValorMaiorQueDez() throws SQLException {
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("12345678910");
		aluno.setNome("testando bll");

		AlunoBLL alunoBLL = new AlunoBLL(connection);
		alunoBLL.Insert(aluno);

		System.out.println("Teste Insert");
	}*/

	/*@Test
	public void testBllSqlInsertNomeAlunoVazio() throws SQLException {
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("0123456789");
		aluno.setNome("");

		AlunoBLL alunoBLL = new AlunoBLL(connection);
		alunoBLL.Insert(aluno);

		System.out.println("Teste Insert");
	}*/

	/*@Test
	public void testBllUpdateAlunoComNomeComValorVazio() throws SQLException {
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("0123456789");
		aluno.setNome("Talita Moura Guedes");

		AlunoBLL alunoBLL = new AlunoBLL(connection);
		alunoBLL.Update(aluno);
		System.out.println("Teste Update");
	}*/

	/*@Test
	public void testBllSqlDeleteAluno() throws SQLException {
		Connection connection = DataBase.getConexao();
		Aluno aluno = new Aluno();
		aluno.setRa("1123456789");
		AlunoBLL alunoBLL = new AlunoBLL(connection);
		alunoBLL.Delete(aluno);
		System.out.println("Teste Delete");
	}*/

}
