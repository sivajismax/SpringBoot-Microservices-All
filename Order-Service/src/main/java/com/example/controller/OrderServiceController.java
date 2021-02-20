package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Itemslist;
import com.example.model.Orders;
import com.example.service.CartServiceProxyCS;
import com.example.service.OrdersRepo;

@RefreshScope
@RestController
@RequestMapping("/api/order")
public class OrderServiceController {

	@Autowired
	private OrdersRepo orderrepo;

	@Autowired
	private CartServiceProxyCS csCS;

	private List<Orders> orderlist;

	@GetMapping("/getallorders")
	public List<Orders> getAllOrders() {
		System.out.println("Getallorders method controller");
		orderlist = orderrepo.findAll();
		return orderlist;
	}

	@GetMapping("/{username}")
	public Orders getOrdersConfirm(@PathVariable("username") String username) {

		Orders o = null;
		boolean b = false;
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		Itemslist itlist = null;
		itlist = csCS.getCartsDetailsCS(username);
		if (itlist != null) {
			System.out.println("Itemslist is not null which comes from Cart service");
			o = orderrepo.save(new Orders(username, itlist.getItem().getItemtotal(), date));
			System.out.println("Orders saved here successfully");
			b = csCS.deleteCartbyUserCS(username);
			if (b)
				System.out.println("Successfully deleted cart " + username);
			else
				System.out.println("UnSuccess deletion cart " + username);
		} else
			System.out.println("Itemsliset is null which comes from cart service");

		return o;
	}

}
