package br.com.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;

import br.com.biblioteca.model.Pedido;

public class PedidoDAO {

	Connection connection = null;
	public PedidoDAO(Connection connection) {
		this.connection = connection;
	}
	
	List<Pedido> Select() throws SQLException{
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "select p.id, a.ra, a.nome, p.quantidade, p.data_pedido, p.data_devolucao from pedido p "
				+ "INNER JOIN aluno a ON p.ra_aluno = a.ra;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.executeQuery();
			try (ResultSet resultSet = preparedStatement.getResultSet()){
				while(resultSet.next()){
					Pedido pedido = new Pedido();
					pedido.setId(resultSet.getInt("p.id"));
					pedido.getAluno().setRa(resultSet.getString("a.ra"));
					pedido.getAluno().setNome(resultSet.getString("a.nome"));
					pedido.setQuantidade(resultSet.getInt("quantidade"));
					pedido.setData_pedido(resultSet.getObject("data_pedido", LocalDate.class)); //getDate("data_pedido").toLocalDate());
					pedido.setData_devolucao(resultSet.getObject("data_devolucao", LocalDate.class)); //getDate("data_devolucao").toLocalDate());
					pedidos.add(pedido);
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
		return pedidos ;
		
	}
	
	public void Insert(Pedido pedido) throws SQLException{
		String sql = "insert into pedido (ra_aluno, quantidade, data_pedido, data_devolucao) values (?,?,?,?);";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, pedido.getAluno().getRa());
			preparedStatement.setInt(2, pedido.getQuantidade());
			preparedStatement.setObject(3, pedido.getData_pedido(), java.sql.Types.DATE);;
			preparedStatement.setObject(4, pedido.getData_devolucao(), java.sql.Types.DATE);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
	
	public void Update(Pedido pedido) throws SQLException{
		String sql = "update pedido set quantidade=?, data_pedido=?, data_devolucao=? where ra_aluno = ?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, pedido.getQuantidade());
			preparedStatement.setObject(2, pedido.getData_pedido(), java.sql.Types.DATE);
			preparedStatement.setObject(3, pedido.getData_devolucao(), java.sql.Types.DATE);
			preparedStatement.setString(4, pedido.getAluno().getRa());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
	
	public void Delete(Pedido pedido) throws SQLException{
		String sql = "delete from pedido where id=?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, pedido.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		connection.close();
	}
}
