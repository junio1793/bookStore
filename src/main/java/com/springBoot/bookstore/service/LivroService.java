package com.springBoot.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.bookstore.dominio.Livro;
import com.springBoot.bookstore.repository.LivroRepository;
import com.springBoot.bookstore.service.exceptions.ObjectNotFoundErros;

@Service
public class LivroService {

	private LivroRepository getLivroRepository;

	@Autowired
	public LivroRepository getLivroRepository(LivroRepository livroRepository) {
		return this.getLivroRepository = livroRepository;
	}

	public Livro findById(Long id) {
		Optional<Livro> livro = getLivroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundErros("Livro não encontrado! id:" + id + Livro.class));
	}

	public List<Livro> getAll() {
		List<Livro> listaLivro = getLivroRepository.findAll();
		if (listaLivro.isEmpty()) {
			return (List<Livro>) new ObjectNotFoundErros("não encontrado!");
		}
		return listaLivro.stream().sorted((livro1, livro2) -> livro1.gettitulo().compareTo(livro2.gettitulo()))
				.collect(Collectors.toList());
	}

}
