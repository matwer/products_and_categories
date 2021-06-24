package com.shad.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.products_and_categories.models.Category;
import com.shad.products_and_categories.models.Product;
import com.shad.products_and_categories.repositories.ProductRepo;

@Service
public class ProductService {
	// instantiates a new repository
	private final ProductRepo productRepo;
	
	// sets up a constructor for the service
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	/**
	 * returns all entries from the repository
	 **/
    public List<Product> allProducts() {
        return productRepo.findAll();
    }
    
	/**
	 * adds a new entry to the repository
	 **/
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
    
	/**
	 * edit an existing entry to the repository
	 **/
    public Product editProduct(Product product) {
        return productRepo.save(product);
    }
    
	/**
	 * gets a product by it's product id
	 **/
    public Product getProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        
        if(product.isPresent()) {
            return product.get();
        } else {        	
        	return null;
        }
    }
    
    public List<Product> findByCategoriesNotContaining(Category category) {
    	return productRepo.findByCategoriesNotContaining(category);
    }

}
