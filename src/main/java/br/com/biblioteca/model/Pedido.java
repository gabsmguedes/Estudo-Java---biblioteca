package br.com.biblioteca.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

	private int id;
	private Aluno aluno;
	private int quantidade;
	private LocalDate data_pedido;
	private LocalDate data_devolucao;

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

	public LocalDate getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDate data_pedido) {
		this.data_pedido = data_pedido;
	}

	public LocalDate getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(LocalDate data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Aluno getAluno() {
		if(this.aluno == null) this.aluno = new Aluno();
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
