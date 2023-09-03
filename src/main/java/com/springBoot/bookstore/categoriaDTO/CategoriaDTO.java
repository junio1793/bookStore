package com.springBoot.bookstore.categoriaDTO;

import com.springBoot.bookstore.dominio.Categoria;

public class CategoriaDTO {

	private Long id;
	private String descricao;
	private String tipo;
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.descricao = categoria.getDescricao();
		this.tipo=categoria.getTipo();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
