package com.shad.products_and_categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shad.products_and_categories.models.Category;
import com.shad.products_and_categories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
	// return products not in a category
	List<Product> findByCategoriesNotContaining(Category category);
}
