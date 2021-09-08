package com.Games.MinhaLoja.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Games.MinhaLoja.Model.UserModel;
import com.Games.MinhaLoja.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplements implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserModel> obj = repository.findByEmail(username);
		
		if(obj.isPresent())
		{
			return new UserDetailsImplements(obj.get());
		}
		else
		{
			throw new UsernameNotFoundException (username + "Não existe.");
		}
	}

}
