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

import br.com.generation.farmaciamaissaude.model.Produtos;
import br.com.generation.farmaciamaissaude.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosrepository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Produtos>> GetAll(){
		return ResponseEntity.ok(produtosrepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> GetById(@PathVariable long id){
		return produtosrepository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/descricao/{produto}")
	public ResponseEntity<List<Produtos>> getByProduto (@PathVariable String produto) {
		return ResponseEntity.ok(produtosrepository.findAllByProdutoContainingIgnoreCase(produto));
	
	}
	
	@PostMapping
	public ResponseEntity<Produtos> post (@RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosrepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> put (@RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtosrepository.save(produto));
		
	}
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		produtosrepository.deleteById(id);
	}
}