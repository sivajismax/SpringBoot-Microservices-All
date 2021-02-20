package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.User;

@FeignClient(name = "product-catalog-service", url = "${spring.pcs.url}")
public interface UserServiceProxyPCS {

	@GetMapping(value = "/checkuser/{username}")
	User checkUserPCS(@PathVariable("username") String username);

}
