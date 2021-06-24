package com.shad.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.products_and_categories.models.Category;
import com.shad.products_and_categories.models.Product;
import com.shad.products_and_categories.repositories.CategoryRepo;

@Service
public class CategoryService {
	// instantiates a new repository
	private final CategoryRepo categoryRepo;
	
	// sets up a constructor for the service
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	
	/**
	 * returns all entries from the repository
	 **/
    public List<Category> allCategorys() {
        return categoryRepo.findAll();
    }
    
    
	/**
	 * adds a new entry to the repository
	 **/
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }
    
    
	/**
	 * adds a new entry to the repository
	 **/
    public Category editCategory(Category category) {
        return categoryRepo.save(category);
    }
    
	/**
	 * gets a category by it's category id
	 **/
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        
        if(category.isPresent()) {
            return category.get();
        } else {        	
        	return null;
        }
    }
    
    public List<Category> findByProductsNotContaining(Product product){
    	return categoryRepo.findByProductsNotContaining(product);
    }

}
