package com.spring.shopmgmnt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.spring.shopmgmnt.entity.Category;
import com.spring.shopmgmnt.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{

	List<Product> findByPname(@Param("pname") String pname);
	List<Product> findByCategory(@Param("category") Category category);
	Product findById(int id);
	
}
