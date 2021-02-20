package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Product;

@FeignClient(name = "product-catalog-service", url = "${spring.pcs.url}")
public interface ProductCatalogServiceProxy {
	@GetMapping(value = "/products/{prodprice}")
	Product getProdPrice(@PathVariable("prodprice") long prodprice);

}
