package com.example.demoEcommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private double price;
	@Column
	private String color;
	@OneToOne(cascade=CascadeType.PERSIST)
	CategoryEntity CaEn;
	@OneToOne(cascade=CascadeType.PERSIST)
	MerchantEntity MeEN;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public CategoryEntity getCaEn() {
		return CaEn;
	}
	public void setCaEn(CategoryEntity caEn) {
		CaEn = caEn;
	}
	public MerchantEntity getMeEN() {
		return MeEN;
	}
	public void setMeEN(MerchantEntity meEN) {
		MeEN = meEN;
	}
	public ProductEntity(int id, String name, double price, String color, CategoryEntity caEn, MerchantEntity meEN) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
		CaEn = caEn;
		MeEN = meEN;
	}
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", CaEn=" + CaEn
				+ ", MeEN=" + MeEN + "]";
	}
	
	
	
	
	

}
