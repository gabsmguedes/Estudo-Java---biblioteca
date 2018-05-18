package br.com.biblioteca.model;

public class Livro {

	private int id;
	private String nome;
	private Autor autor;
	private Editora editora;
	private int quantidade;
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Autor getAutor() {
		if(this.autor == null) this.autor = new Autor();
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		if(this.editora == null) this.editora = new Editora();
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
