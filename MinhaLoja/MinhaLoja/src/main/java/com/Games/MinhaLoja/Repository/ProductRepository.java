package com.Games.MinhaLoja.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Games.MinhaLoja.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

	Object findAllByDescriptionContainingIgnoreCase(String description);

}
