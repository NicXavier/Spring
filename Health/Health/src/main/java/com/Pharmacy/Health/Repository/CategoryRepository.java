package com.Pharmacy.Health.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pharmacy.Health.Model.CategoryModel;

public interface CategoryRepository extends JpaRepository <CategoryModel, Long>{

	List<CategoryModel> findAllByDescriptionContainingIgnoreCase(String description);
	
	
}


