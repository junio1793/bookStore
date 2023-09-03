package com.springBoot.bookstore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springBoot.bookstore.categoriaDTO.CategoriaDTO;
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

	@GetMapping(value = "/todasCategorias")
	public ResponseEntity<List<CategoriaDTO>> getCategoria() {
		List<CategoriaDTO> result = categoriaService.getCategoriaDTOall();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> result = categoriaService.getCategoriaElivros();
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		categoria = categoriaService.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).body(categoria);
	}

	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id,@RequestBody CategoriaDTO categoriaDTO){
		Categoria categoria = categoriaService.update(id,categoriaDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(categoria));
	}		
}
