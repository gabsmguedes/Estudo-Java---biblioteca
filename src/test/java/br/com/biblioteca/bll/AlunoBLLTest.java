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
		AlunoBLL alunoBLL = new AlunoBLL();
		List<Aluno> alunos = alunoBLL.Select();
		for (Aluno aluno : alunos) {
			System.out.println("RA: " + aluno.getRa());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("------------------------------------------");
			System.out.println("Teste Select");
		}
	}

	@Test
	public void testBllSqlInsertRaAlunoComValorMenorQueDez() throws SQLException {

		Aluno aluno = new Aluno();
		aluno.setRa("-1");
		aluno.setNome("testando bll");

		AlunoBLL alunoBLL = new AlunoBLL();
		alunoBLL.Insert(aluno);
		System.out.println("Teste Insert");
	}

	@Test
	public void testBllSqlInsertRaAlunoComValorMaiorQueDez() throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setRa("12345678910");
		aluno.setNome("testando bll");

		AlunoBLL alunoBLL = new AlunoBLL();
		alunoBLL.Insert(aluno);

		System.out.println("Teste Insert");
	}

	@Test
	public void testBllSqlInsertNomeAlunoVazio() throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setRa("0123456789");
		aluno.setNome("");

		AlunoBLL alunoBLL = new AlunoBLL();
		alunoBLL.Insert(aluno);

		System.out.println("Teste Insert");
	}

	@Test
	public void testBllUpdateAlunoComNomeComValorVazio() throws SQLException {

		Aluno aluno = new Aluno();
		aluno.setRa("0123456789");
		aluno.setNome("Talita Moura Guedes");

		AlunoBLL alunoBLL = new AlunoBLL();
		alunoBLL.Update(aluno);
		System.out.println("Teste Update");
	}

	@Test
	public void testBllSqlDeleteAluno() throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setRa("1123456789");
		AlunoBLL alunoBLL = new AlunoBLL();
		alunoBLL.Delete(aluno);
		System.out.println("Teste Delete");
	}

}
