package com.springBoot.bookstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.bookstore.dominio.Livro;
import com.springBoot.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

	private LivroService getLivroService;

	@Autowired
	public LivroService getLivroService(LivroService livroService) {
		return this.getLivroService = livroService;
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Livro> findId(@PathVariable Long id) {
		Livro result = getLivroService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> getAll(){
		List<Livro> list = getLivroService.getAll();
		return ResponseEntity.ok().body(list);
	}

}
