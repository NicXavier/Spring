package com.Pharmacy.Health.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pharmacy.Health.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{
	
	List<ProductModel> findAll();

	List<ProductModel> findAllByDescriptionContainingIgnoreCase(String Description);

}
