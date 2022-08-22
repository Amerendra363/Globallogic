package com.example.BookStore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;



@Entity
@Table(name="User")

public class user {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
long id;
	@Column
String name;
	@Column
long phone;
	@Column
String address;

@OneToMany(cascade=CascadeType.PERSIST)
List<book> Book;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(long id, String name, long phone, String address, List<book> book) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		Book = book;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", Book=" + Book
				+ "]";
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<book> getBook() {
		return Book;
	}
	public void setBook(List<book> book) {
		Book = book;
	}
	
	
}
