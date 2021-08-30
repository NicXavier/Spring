package com.Games.MinhaLoja.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Games.MinhaLoja.Model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

	Object findAllByDescriptionContainingIgnoreCase(String description);

}
