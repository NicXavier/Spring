package com.Games.MinhaLoja.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Games.MinhaLoja.Model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	List<UserModel> findAllByNameContainingIgnoreCase(String name);

	Optional<UserModel> findByEmail(String email);

}
