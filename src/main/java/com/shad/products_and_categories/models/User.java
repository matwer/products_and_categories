package com.shad.products_and_categories.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @Size(min=3, max=200)
	 private String first_name;
	 
	 @Size(min=3, max=200)
	 private String last_name;
	 
	 @Email(message="Please enter a valid email address")
	 private String email;
	 
	 @Size(min=8, message="Password must have at least 8 characters")
	 private String password;
	 
	/**
	 * the @Tranient annotation indicates the passwordConfirmation will not be saved 
	 * in the database, and is used only for validation 
	 */
	 @Transient
	 private String passwordConfirmation;
	 
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 @Column(updatable=false)
	 private Date createdAt;
	 
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	 public User() { }
	 
	 @PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return the passwordConfirmation
	 */
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	
	/**
	 * @param passwordConfirmation the passwordConfirmation to set
	 */
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	 
}


