package com.spring.shopmgmnt.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String pname;
	private double price;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String pname, double price,Category category) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.category=category;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getpname() {
		return pname;
	}
	public void setpname(String pname) {
		this.pname = pname;
	}
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", price="
				+ price + ", category=" + category + "]";
	}
}
