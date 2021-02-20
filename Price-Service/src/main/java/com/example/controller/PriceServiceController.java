package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;

import com.example.service.ProductCatalogServiceProxy;

@RefreshScope
@RestController
@RequestMapping("/api/ps")
public class PriceServiceController {

	@Autowired
	private ProductCatalogServiceProxy pcsp;

	@Value("${coupon.code}")
	private String couponCode;

	@GetMapping("/price/{id}")
	public Product getProd(@PathVariable("id") Long prodid) {
		Product prod = null;
		System.out.println("Here Couponcode is : " + couponCode);
		System.out.println("Entered getProd method Controller");

		// prod = psImpl.getProductPCS(prodid);

		prod = pcsp.getProdPrice(prodid);
		if (prod == null)
			System.out.println("Product Catalog Service Issue May be");
		else
			System.out.println("Product Catalog Service Data got");

		return prod;
	}

}
