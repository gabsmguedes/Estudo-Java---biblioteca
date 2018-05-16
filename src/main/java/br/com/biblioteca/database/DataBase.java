package br.com.biblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	public static Connection getConexao() throws SQLException {
		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "root");

		} catch (Exception e) {
			e.getMessage();

		}

		return connection;
	}

}
