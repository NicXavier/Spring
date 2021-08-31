package com.Pharmacy.Health.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Pharmacy.Health.Model.ProductModel;
import com.Pharmacy.Health.Repository.ProductRepository;

@RestController
@RequestMapping
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAll(){
		List<ProductModel> objectList = repository.findAll();
		 
		if (objectList.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else
		{
			return ResponseEntity.status(200).body(objectList);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getById(@PathVariable (value = "id") Long id){
		Optional<ProductModel> objectList = repository.findById(id);
		
		if (objectList.isPresent())
		{
			return ResponseEntity.status(200).body(objectList.get());
		} else
		{
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/description/{description}")
	public ResponseEntity<List<ProductModel>> getAllByDescription(@PathVariable (value = "description") String Description){
		List<ProductModel> objectList = repository.findAllByDescriptionContainingIgnoreCase(Description);
		
		if (objectList.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else
		{
			return ResponseEntity.status(200).body(objectList);
		}
	}
	
	@PostMapping
	public ResponseEntity<ProductModel> post (@RequestBody ProductModel product){
		return ResponseEntity.status(201).body(repository.save(product));
	}
	
	@PutMapping
	public ResponseEntity<ProductModel> put (@RequestBody ProductModel product){
		return ResponseEntity.status(201).body(repository.save(product));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}
}
