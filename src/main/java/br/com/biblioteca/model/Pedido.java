package br.com.biblioteca.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

	private int id;
	private Aluno aluno;
	private int quantidade;
	private LocalDateTime data_pedido;
	private LocalDateTime data_devolucao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDateTime data_pedido) {
		this.data_pedido = data_pedido;
	}

	public LocalDateTime getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(LocalDateTime data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
