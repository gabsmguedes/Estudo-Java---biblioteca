package br.com.biblioteca.database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DataBaseTest {

	@Test
	public void test() throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "root");
		System.out.println("Conectado com sucesso!");
		connection.close();
	}

}
