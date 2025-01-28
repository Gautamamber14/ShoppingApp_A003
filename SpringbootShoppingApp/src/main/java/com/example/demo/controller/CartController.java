package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.service.CartService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController // @Controller+@ResponseBody
@RequestMapping("/cart") // http://localhost:8080/products
@AllArgsConstructor
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	// @Autowired
	CartService service;

	@PostMapping("/save") // http://localhost:2001/products/save
	public Cart saveCart(@Valid @RequestBody Cart cart) {
		logger.info("Product saved successfully: {}", cart);
		return service.addToCart(cart);

	}
	
	@GetMapping("/getByCartId/{id}") // http://localhost:8080/cart/getByCartId
	public List<Product> getCart(@PathVariable("id") int cartId) {
		
		return service.getCartById(cartId);
	}
	
	@DeleteMapping("/delete/{id}") //http://localhost:8080/cart/delete/id
	public String deleteProduct(@PathVariable("id") int cartId) {
		//logger.info("Product deleted successfully with ID: {}", productId);
		return service.deleteCart(cartId);

	}

	
	
	

	
}