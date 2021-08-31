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

import com.Pharmacy.Health.Model.CategoryModel;
import com.Pharmacy.Health.Repository.CategoryRepository;

@RestController
@RequestMapping
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoryModel>> getAll(){
		List<CategoryModel> objectList = repository.findAll();
		
		if (objectList.isEmpty())
		{
			return ResponseEntity.status(204).build();
		} else
		{
			return ResponseEntity.status(200).body(objectList);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryModel> getById(@PathVariable (value = "id") Long id){
		Optional<CategoryModel> objectList = repository.findById(id);
		
		if (objectList.isEmpty())
		{
			return ResponseEntity.status(200).body(objectList.get());
		} else
		{
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/description/{description}")
	public ResponseEntity<List<CategoryModel>> getAllByDescription(@PathVariable (value = "description") String description){
		List<CategoryModel> objectList = repository.findAllByDescriptionContainingIgnoreCase(description);
		
		if (objectList.isEmpty())
		{
			return ResponseEntity.status(204).build();
		} else
		{
			return ResponseEntity.status(200).body(objectList);
		}
	}
	
	@PostMapping
	public ResponseEntity<CategoryModel> post (@RequestBody CategoryModel category){
		return ResponseEntity.status(201).body(repository.save(category));
		
	}
	
	@PutMapping
	public ResponseEntity<CategoryModel> put (@RequestBody CategoryModel category){
		return ResponseEntity.status(201).body(repository.save(category));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
		
	}
}
