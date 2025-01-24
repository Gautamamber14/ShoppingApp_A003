package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
				
//	@Query("select p1 from Product p1 where p1.productPrice between 25000 and 40000")
//	public List<Product> getAllProductBetween(int intialPrice, int finalPrice);
//	
//	@Query("select p1 from Product p1 where p1.productCategory=?1")
//	public List<Product> getAllProductByCategory(String category);
//	
	
	public List<Product> findByProductPriceBetween(int initialPrice, int finalPrice);
	public List<Product> findByProductCategory(String category);

	
	
}
