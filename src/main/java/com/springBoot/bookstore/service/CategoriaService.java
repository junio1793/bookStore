package com.springBoot.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.bookstore.categoriaDTO.CategoriaDTO;
import com.springBoot.bookstore.dominio.Categoria;
import com.springBoot.bookstore.repository.CategoriaRepository;
import com.springBoot.bookstore.service.exceptions.ObjectNotFoundErros;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository getCategoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> optional = getCategoriaRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundErros("Categoria não encontrada! id: " + id));
	}

	public Categoria getTipoCatagoria(String tipo){
		List<Categoria> lista = getCategoriaRepository.findAll();
		return lista.stream()
				.filter(categoria -> categoria.getTipo().equals(tipo))
				.findFirst()
				.orElseThrow(() -> new ObjectNotFoundErros("tipo não encontrado! tipo: " + tipo));
	}
	
	public Categoria getDescricao(String descricao) {
		List<Categoria> lista = getCategoriaRepository.findAll();
		return lista.stream()
				.filter(categoria -> categoria.getDescricao().equals(descricao))
				.findFirst()
				.orElseThrow(()-> new ObjectNotFoundErros("Descrição não encontrada: -> " + descricao));
	}
	
	public List<CategoriaDTO> getCategoriaDTOall(){
		List<Categoria> categoria = getCategoriaRepository.findAll();
		return categoria.stream().map(x -> new CategoriaDTO(x)).toList();
	}
	
	public List<Categoria> getCategoriaElivros(){
		List<Categoria> lista = getCategoriaRepository.findAll();
		return lista;
	}

	public Categoria save(Categoria categoria) {
		categoria.setId(null);
		return getCategoriaRepository.save(categoria);
	}

	public Categoria update(Long id, CategoriaDTO categoriaDTO) {
		Categoria categoria = findById(id);
		categoria.setTipo(categoriaDTO.getTipo());
		categoria.setDescricao(categoriaDTO.getDescricao());
		return getCategoriaRepository.save(categoria);
	}
}
