package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    //@Autowired
    ProductService service;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product) {
        logger.info("Saving product: {}", product);
        return service.addProduct(product);
    }

    @PutMapping("/update") //http://localhost:8081/products/update
    public Product updateProduct(@RequestBody Product product) {
        logger.info("Updating product: {}", product);
        return service.updateProduct(product);
    }

    @PostMapping("/delete/{id}") //http://localhost:8081/products/delete/123
    public String deleteProduct(@PathVariable("id") int productId) {
        logger.info("Deleting product with ID: {}", productId);
        return service.deleteProduct(productId);
    }

    @GetMapping("/getById/{id}") //http://localhost:8081/products/getById/123
    public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
        logger.info("Fetching product with ID: {}", productId);
        return service.getProductById(productId);
    }

    @GetMapping("/getAll") //http://localhost:8081/products/getAll/123
    public List<Product> getAllProduct() {
        logger.info("Fetching all products");
        return service.getAllProduct();
    }

    @GetMapping("/getBetween/{price1}/{price2}") //http://localhost:8081/products/getBetween/1000/2000
    public List<Product> getAllBetween(@PathVariable("price1") int initialPrice, @PathVariable("price2") int finalPrice) {
        logger.info("Fetching products between prices: {} and {}", initialPrice, finalPrice);
        return service.getAllProductBetween(initialPrice, finalPrice);
    }

    @GetMapping("/getCategory/{category}") //http://localhost:8080/products/getCategory/1000/2000
    public List<Product> getAllProductByCategory(@PathVariable("category") String category) {
        logger.info("Fetching products by category: {}", category);
        return service.getAllProductCategory(category);
    }
}
