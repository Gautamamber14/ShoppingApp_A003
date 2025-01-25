package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;

public interface ProductService {

	public abstract String addProduct(Product product);

	public abstract Product updateProduct(Product product);

	public abstract String deleteProduct(int productId);

	public abstract Product getProductById(int productId) throws ProductNotFound;

	public abstract List<Product> getAllProduct();

	public abstract List<Product> getAllProductBetween(int initialPrice, int finalPrice);
	
	public abstract List<Product> getAllProductCategory(String productCategory);

	


}
