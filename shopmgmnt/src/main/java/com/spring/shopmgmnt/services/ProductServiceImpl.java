package com.spring.shopmgmnt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.shopmgmnt.dao.ProductDAO;
import com.spring.shopmgmnt.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDao;
//	List<Product> list;
	public ProductServiceImpl() {
		super();
//		list = new ArrayList<>();
//		list.add(new Product(1, "Kurti", 1000));
//		list.add(new Product(2, "Shoe", 1500));
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product addProduct(Product p) {
		// TODO Auto-generated method stub
		productDao.save(p);
		return p;
	}

	@Override
	public Product updateProduct(Product p) {
		Product update_product = productDao.findById(p.getid());
		update_product.setCategory(p.getCategory());
		update_product.setpname(p.getpname());
		update_product.setprice(p.getprice());
		return productDao.save(update_product);
		
	}

	@Override
	public List<Product> deleteProduct(int id) {
		// TODO Auto-generated method stub
		Product delete_product = productDao.getOne(id);
		productDao.delete(delete_product);
		return productDao.findAll();
		
	}

	

	
	

}

