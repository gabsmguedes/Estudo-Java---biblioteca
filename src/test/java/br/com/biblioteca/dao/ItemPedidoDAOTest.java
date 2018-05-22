package br.com.biblioteca.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.com.biblioteca.database.DataBase;
import br.com.biblioteca.model.ItemPedido;

public class ItemPedidoDAOTest {

	@Test
	public void testSqlDeleteItemPedido() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.getLivro().setId(3);
		itemPedido.getPedido().setId(1);
		itemPedidoDAO.DeleteLivro(itemPedido);
	}
	
	/*@Test
	public void testSqlUpdateItemPedido() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.getLivro().setId(3);
		itemPedido.getPedido().setId(1);
		itemPedidoDAO.Update(itemPedido);
	}*/
	
	/*@Test
	public void testSqlInsertItemPedido() throws SQLException{
		
		Connection connection = DataBase.getConexao();
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.getPedido().setId(1);
		itemPedido.getLivro().setId(3);
		
		itemPedidoDAO.Insert(itemPedido);
		
	}*/
	
	@Test
	public void testSqlSelectItemPedido() throws SQLException {
		
		Connection connection = DataBase.getConexao();
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(connection);
		
		List<ItemPedido> itemPedidos = itemPedidoDAO.Select();
		
		for (ItemPedido itemPedido : itemPedidos) {
			System.out.println("ID Pedido: " + itemPedido.getPedido().getId());
			System.out.println("ID Livro: " + itemPedido.getLivro().getId());
			System.out.println("Nome Livro: " + itemPedido.getLivro().getNome());
			System.out.println("Quantidade: " + itemPedido.getQuantidade());
			System.out.println("----------------------------------------------------");
		}
	}

}
