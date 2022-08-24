package com.globallogic.book.entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String name;
	
	@Column
	String address;
	
	@Column
	long phoneNo;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	SignUp signUp;
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Admin(SignUp signUp) {
		super();
		this.signUp = signUp;
	}
	
	
	
	public Admin(int id, SignUp signUp) {
		super();
		this.id = id;
		this.signUp = signUp;
	}



	public Admin(int id, String name, String address, long phoneNo, SignUp signUp) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.signUp = signUp;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public SignUp getSignUp() {
		return signUp;
	}

	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + ", signUp="
				+ signUp + "]";
	}

}
