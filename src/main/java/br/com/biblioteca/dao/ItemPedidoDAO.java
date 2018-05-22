package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.model.ItemPedido;

public class ItemPedidoDAO {

	Connection connection = null;
	public ItemPedidoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<ItemPedido> Select() throws SQLException{
		List<ItemPedido> itensPedidos = new ArrayList<>();
		String sql = "select p.id, l.id, l.nome from item_pedido i "
				+ "inner join pedido p on i.id_pedido = p.id "
				+ "inner join livro l on i.id_livro = l.id";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.executeQuery();
			try (ResultSet resultSet = preparedStatement.getResultSet()){
				while(resultSet.next()){
					ItemPedido itemPedido = new ItemPedido();
					itemPedido.getPedido().setId(resultSet.getInt("id"));
					itemPedido.getLivro().setId(resultSet.getInt("id"));
					itemPedido.getLivro().setNome(resultSet.getString("nome"));
					itensPedidos.add(itemPedido);
				}
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
		return itensPedidos ;
	}
	
	public void Insert(ItemPedido itemPedido) throws SQLException{
		String sql = "insert into item_pedido (id_pedido, id_livro) values(?,?);";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, itemPedido.getPedido().getId());
			preparedStatement.setInt(2, itemPedido.getLivro().getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
	
	/*public void Update(ItemPedido itemPedido) throws SQLException{
		String sql = "update item_pedido set id_livro=? where id_pedido=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, itemPedido.getLivro().getId());
			preparedStatement.setInt(2, itemPedido.getPedido().getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}*/
	
	public void DeleteLivro(ItemPedido itemPedido) throws SQLException{
		String sql = "delete from item_pedido where id_pedido=? and id_livro=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, itemPedido.getPedido().getId());
			preparedStatement.setInt(2, itemPedido.getLivro().getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
}
