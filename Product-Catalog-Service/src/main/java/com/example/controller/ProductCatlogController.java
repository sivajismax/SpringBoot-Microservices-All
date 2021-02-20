package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.model.Review;
import com.example.model.User;
import com.example.repository.ProductRepository;
import com.example.repository.ReviewRepository;
import com.example.repository.UserRepo;

@RestController
@RequestMapping(value = RestURIConstants.PRODSERVICE_MAIN)
public class ProductCatlogController {

	@Autowired
	private ProductRepository prodrepo;

	@Autowired
	private ReviewRepository revwrepo;

	@Autowired
	private UserRepo userrepo;

	private List<Product> prodlist;

	private List<Review> revwlist;

	private Product product;

	private Review review;

	private User user;

	private String msg = "";

	@PostMapping("/postusers")
	public User postUsers(@RequestBody User usr) {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		System.out.println("Here Postusers method");
		usr.setLoginTime(date);
		user = userrepo.save(usr);
		return user;
	}

	@GetMapping(value = RestURIConstants.PROD_CHECKUSER)
	public User checkUser(@PathVariable("username") String username) {
		// String umsg = "User Not available";
		System.out.println("Entered CheckUser method Controller");
		user = userrepo.findUserByUserName(username);
		return user;
	}

	@GetMapping(value = RestURIConstants.GET_PROD_ALL)
	public List<Product> getProducts() {
		System.out.println("Entered getProducts method Controller");
		prodlist = prodrepo.findAll();
		return prodlist;
	}

	@GetMapping(value = RestURIConstants.GET_PROD_BYID)
	public Product getProdById(@PathVariable("id") int prodid) {
		System.out.println("Entered getProd method Controller");
		product = prodrepo.findProductById(prodid);
		return product;
	}

	@GetMapping(value = RestURIConstants.GET_PROD_BYMATCHNAME)
	public List<Product> getProdByMatchName(@PathVariable("matchletter") String prodname) {
		System.out.println("Entered getProdByMatchName method Controller");
		prodlist = prodrepo.findByMatchNameLetter(prodname);
		return prodlist;
	}

	@PostMapping(value = RestURIConstants.POST_PROD)
	public String postProduct(@RequestBody Product prod) {
		System.out.println("Entered post product method Controller");
		msg = "";
		msg = "Coming Object is null";
		if (prod != null) {
			msg = "Coming Single Object is full";
			product = prodrepo.save(prod);
			if (product != null)
				msg = msg + " & Object is successfully saved";
			else
				msg = msg + " & Object is not saved to repo, Please check issue";

		}
		return msg;
	}

	@PostMapping(value = RestURIConstants.POST_PROD_ALL)
	public String postProducts(@RequestBody List<Product> pl) {
		System.out.println("Entered post products method Controller");
		msg = "";
		msg = "Coming Objects are null";
		if (!pl.isEmpty()) {
			msg = "Coming Objects are full";
			prodlist = prodrepo.saveAll(pl);
			if (!prodlist.isEmpty())
				msg = msg + " & Objects are successfully saved";
			else
				msg = msg + " & Objects are not saved to repo, Please check issue";
		}
		return msg;
	}

	@GetMapping(value = RestURIConstants.GET_REVW_ALL)
	public List<Review> getReviews() {
		System.out.println("Entered getreview method Controller");
		revwlist = revwrepo.findAll();
		return revwlist;
	}

	@GetMapping(value = RestURIConstants.GET_REVW_BYPRODID)
	public List<Review> getReviewsByProd(@PathVariable("id") int prodid) {
		System.out.println("Entered getreviewby prodid method Controller");
		revwlist = revwrepo.findByProdIdReviewList(prodid);
		return revwlist;
	}

	@PostMapping(value = RestURIConstants.POST_REVW_FORPRODID)
	public Review postReviewForProdId(@PathVariable("id") int prodid, @RequestBody Review rev) {
		System.out.println("Entered post reviews for products method Controller");
		review = null;
		msg = "";
		if (rev != null) {
			System.out.println("Here came not review null");
			product = prodrepo.findProductById(prodid);
			System.out.println("I am printing here product object " + product);
			rev.setProduct(product);
			review = revwrepo.save(rev);
			msg = "Coming Objects are full";
			if (review != null) {
				msg = msg + " & Objects are successfully saved";
			} else
				msg = msg + " & Objects are not saved to repo, Please check issue";
		}
		System.out.println(msg + " " + prodid + " " + rev);
		return review;
	}

}
