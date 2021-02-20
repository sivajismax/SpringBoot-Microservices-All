package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Product;
import com.example.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "select * From User where user_name = ?1 ", nativeQuery = true)
	User findUserByUserName(String username);
}
