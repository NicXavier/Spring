package com.Games.MinhaLoja.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Games.MinhaLoja.Model.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

	public Object findAllByDescriptionContainingIgnoreCase(String description);
}
