package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
	
	CartRepository repository;
	
	@Override
	public Cart addToCart(Cart cart) {
		
		return repository.save(cart);
	}

	@Override
	public List<Product> getCartById(int cartId) {
		Optional<Cart> optional = repository.findById(cartId);
		if (optional.isPresent()) {
			return optional.get().getProducts();
		} else 
			return null;
	}

	@Override
	public String deleteCart(int cartId) {
		repository.deleteById(cartId);
		return "Cart deleted sucessfully";
		
	}
	

}
