package com.spring.shopmgmnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shopmgmnt.dao.ProductDAO;
import com.spring.shopmgmnt.entity.Category;
import com.spring.shopmgmnt.entity.Product;
import com.spring.shopmgmnt.services.ProductService;
@RestController
@CrossOrigin(origins = "*")
public class MyController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductDAO productDAO;
	
	@GetMapping("/home")
	public String home() {
		return "This is a Shopping Management System...";
	}
	@GetMapping("/getAllproducts")
	public List<Product> getProducts(){
		return this.productService.getProducts();
	}
	@GetMapping("/products/name")
	public ResponseEntity<List<Product>> getProductByName(@RequestParam String pname) {
		return new ResponseEntity<List<Product>>(productDAO.findByPname(pname),HttpStatus.OK);
	}
	@GetMapping("/products/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") Category category){
		return new ResponseEntity<List<Product>>(productDAO.findByCategory(category),HttpStatus.OK);
	}
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product p)
	{
		return this.productService.addProduct(p);
	}
	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product pr){
		return new ResponseEntity<Product>(productService.updateProduct(pr),HttpStatus.OK);
	}
	@DeleteMapping("/products/{id}")
	public List<Product> deleteProduct(@PathVariable String id){
		 this.productService.deleteProduct(Integer.parseInt(id));
		 return this.productService.getProducts();
	}
}
