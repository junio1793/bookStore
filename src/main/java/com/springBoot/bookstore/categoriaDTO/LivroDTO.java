package com.springBoot.bookstore.categoriaDTO;

import com.springBoot.bookstore.dominio.Livro;

public class LivroDTO {

	private Long id;
	private String autor;
	private String titulo;

	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.gettitulo();
		this.autor = livro.getAutor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
