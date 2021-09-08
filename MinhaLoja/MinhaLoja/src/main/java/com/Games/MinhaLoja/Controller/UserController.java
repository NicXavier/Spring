package com.Games.MinhaLoja.Controller;

	import java.util.List;
	import java.util.Optional;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import com.Games.MinhaLoja.Model.UserModel;
	import com.Games.MinhaLoja.Model.UtilityModel.UserDTO;
	import com.Games.MinhaLoja.Repository.UserRepository;
	import com.Games.MinhaLoja.Services.UserServices;

	@RestController
	@RequestMapping("/user")
	public class UserController {

		@Autowired
		private UserRepository repository;
		
		@Autowired 
		private UserServices services;
		
		@GetMapping
		public ResponseEntity <List<UserModel>> getAll (){
			List<UserModel> obj = repository.findAll();
			
			if (obj.isEmpty())
			{
				return ResponseEntity.status(204).build();
			}
			else
			{
				return ResponseEntity.status(200).body(obj);
			}
		}
		
		

	 	@PostMapping("/save")
	 	public ResponseEntity <Object> post (@Valid @RequestBody UserModel newUser){
	 		Optional <Object> obj = services.registerUser(newUser);
	 	{
	 		if(obj.isEmpty())
	 		{
	 			return ResponseEntity.status(400).build();
	 		}
	 		else
	 		{
	 			return ResponseEntity.status(201).body(obj.get());
	 		}
	 	}
	 	}
	 	@PutMapping ("/credentials")
	 	public ResponseEntity<Object> credentials (@Valid @RequestBody UserDTO userToAuthenticate){
	 		Optional <?> obj1 = services.catchCredentials(userToAuthenticate);
	 		
	 		if (obj1.isEmpty())
	 		{
	 			return ResponseEntity.status(400).build();
	 		}
	 		else
	 		{
	 			return ResponseEntity.status(201).body(obj1.get());
	 		}
	 	}
	 	
	 	@GetMapping("/{id}")
		public ResponseEntity<UserModel> getById (@PathVariable (value = "id") Long id){
			Optional<UserModel> obj = repository.findById(id);
			
			if (obj.isPresent())
			{
				return ResponseEntity.status(200).body(obj.get());
			}
			else
			{
				return ResponseEntity.status(204).build();
			}
		}
			
		@GetMapping("name/{name}")
		public ResponseEntity <List<UserModel>> GetByNameI (@PathVariable (value = "name") String name)
		{
			List<UserModel> objectList = repository.findAllByNameContainingIgnoreCase(name);
				
			if (objectList.isEmpty())
			{
				return ResponseEntity.status(204).build();
			} else
			{
				return ResponseEntity.status(200).body(objectList);
			}
			
		}
		@GetMapping("/search")
		public ResponseEntity<List<UserModel>> GetByNameII (@RequestParam (defaultValue = "") String name){
			List<UserModel> objectList = repository.findAllByNameContainingIgnoreCase(name);
			
			if (objectList.isEmpty()) {
				return ResponseEntity.status(204).build();
			} else 
			{
				return ResponseEntity.status(200).body(objectList);
			}
		}
		
		@PutMapping("/update")
		public ResponseEntity<UserModel> put (@Valid @RequestBody UserModel updateUser){
			return ResponseEntity.status(201).body(repository.save(updateUser));
		}

		@DeleteMapping("/{id}")
		public void delete (@PathVariable (value = "id") long id) {
			repository.deleteById(id);
	}
	 	
	
	}


