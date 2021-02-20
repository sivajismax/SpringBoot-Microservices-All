package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Product;

@FeignClient(name = "price-service", url = "${spring.price.url}")
public interface PriceServiceProxyPS {

	@GetMapping(value = "/price/{id}")
	Product getProductPricePS(@PathVariable("id") int id);

}