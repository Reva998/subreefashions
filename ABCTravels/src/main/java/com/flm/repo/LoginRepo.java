package com.flm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flm.model.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{
	

	    // Deletes user by email
	    void deleteByEmail(String email);

	    // Optional: to check if a user exists
	    boolean existsByEmail(String email);
	}


