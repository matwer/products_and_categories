package com.shad.products_and_categories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shad.products_and_categories.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>  {
	User findByEmail(String email);
}


