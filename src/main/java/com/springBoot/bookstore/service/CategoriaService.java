package com.springBoot.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.bookstore.dominio.Categoria;
import com.springBoot.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository getCategoriaRepository;

	public Categoria findById(Long id) {
		Optional<Categoria> optional = getCategoriaRepository.findById(id);
		return optional.orElse(null);
	}
	
}
