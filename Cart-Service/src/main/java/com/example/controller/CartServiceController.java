package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Itemslist;
import com.example.model.Product;
import com.example.model.User;
import com.example.service.ItemslistRepo;
import com.example.service.PriceServiceProxyPS;
import com.example.service.UserServiceProxyPCS;

@RestController
@RequestMapping("/api/cart")
public class CartServiceController {

	@Autowired
	private UserServiceProxyPCS usPCS;

	@Autowired
	private PriceServiceProxyPS psPS;

	@Autowired
	private ItemslistRepo itemlistrepo;

	private List<Itemslist> ilistlist;

	@GetMapping("/getcart/{username}")
	public Itemslist getItemCartUserName(@PathVariable("username") String username) {
		Itemslist il = null;
		System.out.println("getItemCartUserName controller method here");
		il = itemlistrepo.findByItemslistUsername(username);
		return il;
	}

	@GetMapping("/getallcart")
	public List<Itemslist> getItemslist() {
		System.out.println("getItemslist controller method");
		ilistlist = itemlistrepo.findAll();
		return ilistlist;
	}

	@DeleteMapping("/deletecart/{username}")
	public boolean deleteCartByUsername(@PathVariable("username") String username) {
		StringBuilder sb = new StringBuilder();
		System.out.println("deleteCartByUsername ::::::::::::::::::::=====================>");
		boolean b = false;
		Itemslist itemlist = itemlistrepo.findByItemslistUsername(username);
		
		try {
			itemlistrepo.delete(itemlist);
			sb.append("successfully deletion here in deleteCartByUsername method \n");
		} catch (Exception e) {
			sb.append("Unsuccessfully deletion her in deleteCartByUsername method \n");
			e.getMessage();
		}
		System.out.println("Checking here whether user cart user is deleted or not");
		Itemslist itemlist1 = itemlistrepo.findByItemslistUsername(username);
		if (itemlist1 != null)
			b = true;
		sb.append("successfully deleted from Carts username " + username);
		System.out.println(sb.toString());
		System.out.println("deleteCartByUsername ::::::::::::::::::::=====================>");
		return b;
	}

	@PostMapping("/{username}")
	public Itemslist postCartData(@PathVariable("username") String username, @RequestBody Itemslist itemslist) {
		System.out.println("PostCartData ::::::::::::::::::::=====================>");
		Itemslist itemlist = new Itemslist();
		Itemslist iteml = null;
		User usr = null;
		Product prod = null;
		System.out.println("Came here to postCartData method");
		usr = usPCS.checkUserPCS(username);

		System.out.println("Here before if condition user : " + usr);
		if (usr != null) {
			itemlist = itemslist;
			prod = psPS.getProductPricePS(itemslist.getItem().getId());
			System.out.println("after the prod details from price service: " + prod);
			itemlist.setUsername(username);

			int qt = itemlist.getQty();
			double pric = prod.getPrice();
			double tp = qt + pric;
			long it = (long) (tp);

			itemlist.getItem().setPrice(pric);
			itemlist.getItem().setItemtotal(it);
			iteml = itemlistrepo.save(itemlist);

		} else
			System.out.println("User UnAvailable here");
		System.out.println("PostCartData ::::::::::::::::::::=====================<  ");
		return itemlist;
	}
}
