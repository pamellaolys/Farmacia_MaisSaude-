package br.com.generation.farmaciamaissaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.generation.farmaciamaissaude.model.Categoria;
import br.com.generation.farmaciamaissaude.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders= "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(categoriarepository.findAll());
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return categoriarepository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriarepository.findAllByDescricaoContainingIgnoreCase(descricao));
		
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriarepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriarepository.save(categoria));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		categoriarepository.deleteById(id);
	}
}
