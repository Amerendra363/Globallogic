package com.example.BookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;
	@Column
String name;
	@Column
String authorname;
	@Column
double price;
	
	
	public book(long id, String name, String authorname, double price) {
		super();
		this.id = id;
		this.name = name;
		this.authorname = authorname;
		this.price = price;
	}
	
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "book [id=" + id + ", name=" + name + ", authorname=" + authorname + ", price=" + price + "]";
	}
	
}
