package br.com.biblioteca.model;

import java.util.List;

public class Livro {

	private int id;
	private Autor autor;
	private Editora editora;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
