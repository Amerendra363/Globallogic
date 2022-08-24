package com.globallogic.book.entity;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	
	@Column
	String idUser;
	
	@Column
	int idBook;
	
	@Column
	String shippingAddress;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String idUser, int idBook, String shippingAddress) {
		super();
		this.orderId = orderId;
		this.idUser = idUser;
		this.idBook = idBook;
		this.shippingAddress = shippingAddress;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int bookId) {
		this.idBook = bookId;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", idUser=" + idUser + ", idBook=" + idBook + ", shippingAddress="
				+ shippingAddress + "]";
	}
	
	

}
