package br.com.biblioteca.model;

import java.util.List;

public class ItemPedido {

	private Pedido pedido;
	private Livro livro;
	private int quantidade;

	public Pedido getPedido() {
		if(this.pedido == null) this.pedido = new Pedido();
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	

}
