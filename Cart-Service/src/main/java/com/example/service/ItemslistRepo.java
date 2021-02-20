package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Itemslist;

public interface ItemslistRepo extends JpaRepository<Itemslist, Integer> {

	@Query(value = "SELECT * FROM Itemslist WHERE username=?1", nativeQuery = true)
	Itemslist findByItemslistUsername(String username);

	

}
