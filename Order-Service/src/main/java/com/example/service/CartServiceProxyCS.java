package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Itemslist;

@FeignClient(name = "cart-service", url = "${spring.cart.url}")
public interface CartServiceProxyCS {

	@GetMapping("/getcart/{username}")
	Itemslist getCartsDetailsCS(@PathVariable("username") String username);

	@DeleteMapping("/deletecart/{username}")
	boolean deleteCartbyUserCS(@PathVariable("username") String username);

}
