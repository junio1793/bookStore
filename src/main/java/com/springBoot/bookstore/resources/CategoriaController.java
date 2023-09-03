package com.springBoot.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.bookstore.dominio.Categoria;
import com.springBoot.bookstore.service.CategoriaService;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
		Categoria resultado = categoriaService.findById(id);
		return ResponseEntity.ok().body(resultado);
	}

	@GetMapping(value = "/tipo/{tipo}")
	public ResponseEntity<Categoria> getCatPorTipo(@PathVariable String tipo) {
		Categoria result = categoriaService.getTipoCatagoria(tipo);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/descricao/{descricao}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable String descricao) {
		Categoria result = categoriaService.getDescricao(descricao);
		return ResponseEntity.ok().body(result);
	}
}
