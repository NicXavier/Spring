package com.Games.MinhaLoja.Controller;

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

import com.Games.MinhaLoja.Model.ProductModel;
import com.Games.MinhaLoja.Repository.ProductRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProductModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<ProductModel> GetAllByID (@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/description/{description}")
	public ResponseEntity<Object> GetAllByDescription (@PathVariable String Description){
	return ResponseEntity.ok(repository.findAllByDescriptionContainingIgnoreCase(Description));
	}
	
	@PostMapping("/search")
	public ResponseEntity<ProductModel> post (@RequestBody ProductModel product){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProductModel> put (@RequestBody ProductModel product){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
	}
	
	@DeleteMapping("{/id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
