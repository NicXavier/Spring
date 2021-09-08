package com.Games.MinhaLoja.Services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import com.Games.MinhaLoja.Model.UserModel;
import com.Games.MinhaLoja.Model.UtilityModel.UserDTO;
import com.Games.MinhaLoja.Repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;
	private String authorizationHeader;
	
	public Optional<Object> registerUser (UserModel newUser) {
		return repository.findByEmail(newUser.getEmail()).map(userExisting -> {
			return Optional.empty();
		}).orElseGet(() -> {
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode (newUser.getPassword());
		newUser.setPassword(result);
		return Optional.ofNullable(repository.save(newUser));  
		});
	}
	public Optional <?> catchCredentials (UserDTO userToAuthenticate) {
		return repository.findByEmail(userToAuthenticate.getEmail()).map(userExistent -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			if (encoder.matches(userToAuthenticate.getPassword(), userExistent.getPassword())) {
				String structureBasic = userToAuthenticate.getEmail() + ":" + userToAuthenticate.getPassword();
				byte [] authorizationBase64 = encodeBase64(structureBasic.getBytes(Charset.forName ("US-ASCII")));
				userToAuthenticate.setToken(authorizationHeader);
				userToAuthenticate.setId(userExistent.getId());
				userToAuthenticate.setName(userExistent.getName());
				userToAuthenticate.setPassword(userExistent.getPassword());
				return Optional.ofNullable(userToAuthenticate);
				
			}
			else
			{
				return Optional.empty();
			}
		}). orElseGet(() -> {
			return Optional.empty();
		});
	}
	private byte[] encodeBase64(byte[] bytes) {
		// TODO Auto-generated method stub
		return null;
	}
}

	


