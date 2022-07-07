package br.com.elasgen.elasgen.controller;

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

import br.com.elasgen.elasgen.model.Categorias;
import br.com.elasgen.elasgen.repository.CategoriasRepository;

@RestController
@RequestMapping("categorias")
@CrossOrigin( origins = "*" , allowedHeaders = "*")
public class CategoriasController {
	
	
	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> getall(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categorias>> getByTipo(@PathVariable String tipo ){
		return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));
		}
	
	@PostMapping
	public ResponseEntity<Categorias> post (@RequestBody Categorias categorias){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
		
	}
	
	@PutMapping
	public ResponseEntity<Categorias> put (@RequestBody Categorias categorias){
		return ResponseEntity.ok(repository.save(categorias));
		
	}
	
	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
