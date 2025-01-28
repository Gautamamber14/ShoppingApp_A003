package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;

public interface CartService {
		
	public abstract Cart addToCart(Cart cart);

	public abstract List<Product> getCartById(int cartId);
	
	public abstract String deleteCart(int cartId);
	
	//public abstract Cart removeFromCart(Cart cart);
	

	
}
