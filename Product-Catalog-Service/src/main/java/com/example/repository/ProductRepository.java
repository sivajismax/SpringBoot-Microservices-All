package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * From Product where id = ?1 ", nativeQuery = true)
	Product findProductById(int id);
	
	@Query(value = "SELECT * FROM Product WHERE lower(name) like lower(%?1%)", nativeQuery = true)
	List<Product> findByMatchNameLetter(String matchletter);
	
	
}
