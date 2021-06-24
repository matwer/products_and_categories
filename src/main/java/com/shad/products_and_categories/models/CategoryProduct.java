package com.shad.products_and_categories.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="categories_products")
public class CategoryProduct {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 @Column(updatable=false)
	 private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	   
	 @PreUpdate
	 protected void onUpdate(){
	   	this.updatedAt = new Date();
	 }

	 @PrePersist
	 protected void onCreate(){
	   	this.createdAt = new Date();
	 }
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="product_id")
	 private Product product;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="category_id")
	 private Category category;
	 
	 public CategoryProduct() {
	     
	 }
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
 
}


