package br.com.biblioteca.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.Pedido;

public class PedidoDAOTest {

	
	/*@Test
	public void testSqlInsertPedido() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		Pedido pedido = new Pedido();
		pedido.getAluno().setRa("1421450077");
		pedido.setQuantidade(0);
		LocalDate data_pedido = LocalDate.of(2018, 05, 21);
		pedido.setData_pedido(data_pedido);
		LocalDate data_devolucao = LocalDate.of(2018, 05, 31);
		pedido.setData_devolucao(data_devolucao);
		PedidoDAO pedidoDAO = new PedidoDAO(connection);
		pedidoDAO.Insert(pedido);
		
	}*/
	
	
	
	/*@Test
	public void testSqlUpdatePedido() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		Pedido pedido = new Pedido();
		pedido.getAluno().setRa("1421450077");
		pedido.setQuantidade(4);
		LocalDate data_pedido = LocalDate.of(2018, 05, 21);
		pedido.setData_pedido(data_pedido);
		LocalDate data_devolucao = LocalDate.of(2018, 05, 31);
		pedido.setData_devolucao(data_devolucao);
		
		PedidoDAO pedidoDAO = new PedidoDAO(connection);
		pedidoDAO.Update(pedido);
	}*/
	
	/*@Test
	public void testSqlDeletePedido() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		Pedido pedido = new Pedido();
		pedido.setId(3);
		
		PedidoDAO pedidoDAO = new PedidoDAO(connection);
		pedidoDAO.Delete(pedido);
	}*/
	
	@Test
	public void testSqlSelectPedido() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		PedidoDAO pedidoDAO = new PedidoDAO(connection);
		
		List<Pedido> pedidos = pedidoDAO.Select();
		
		for (Pedido pedido : pedidos) {
			System.out.println("Id: " + pedido.getId());
			System.out.println("RA: " + pedido.getAluno().getRa());
			System.out.println("Nome Aluno: " + pedido.getAluno().getNome());
			System.out.println("Quantidade de livro: " + pedido.getQuantidade());
			System.out.println("Data do Pedido: " + pedido.getData_pedido());
			System.out.println("Data da Devolucao: " + pedido.getData_devolucao());
			System.out.println("-----------------------------------------------------");
			
		}
	}

}
