package com.springBoot.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springBoot.bookstore.dominio.Categoria;
import com.springBoot.bookstore.dominio.Livro;
import com.springBoot.bookstore.repository.CategoriaRepository;
import com.springBoot.bookstore.repository.LivroRepository;

@SpringBootApplication
public class LojaDeLivrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LojaDeLivrosApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository getCategoriaRepository;
	
	@Autowired
	private LivroRepository getLivroRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria  c1 = new Categoria(null, "aventura", "livros de aventura");
		Categoria  c2 = new Categoria(null, "romance", "livros de romace");
		
		
		Livro l1 = new Livro(null, "DUNA", "Frank Herbert",c1);
		Livro l2 = new Livro(null, "viagem ao centro da terra", "julio verne",c1);
		Livro l3 = new Livro(null, "Orgulho e Preconceito"," Jane Austen",c2);
		Livro l4 = new Livro(null, "O Amor nos Tempos do Cólera", "Gabriel García Márquez",c2);
		
		c1.getLivro().addAll(Arrays.asList(l1,l2));
		c2.getLivro().addAll(Arrays.asList(l3,l4));
		
		this.getCategoriaRepository.saveAll(Arrays.asList(c1,c2));
		this.getLivroRepository.saveAll(Arrays.asList(l1,l2,l3,l4));
		}

}
