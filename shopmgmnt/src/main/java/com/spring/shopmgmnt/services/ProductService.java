package com.spring.shopmgmnt.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spring.shopmgmnt.entity.Product;

public interface ProductService {
	public List<Product> getProducts();
	public Product addProduct(Product p);
	public Product updateProduct(Product p);
	public List<Product> deleteProduct(int pid);

}
