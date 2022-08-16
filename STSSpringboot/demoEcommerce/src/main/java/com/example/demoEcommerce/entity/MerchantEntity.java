package com.example.demoEcommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "merchant")
public class MerchantEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private long pinCode;
	
	@Column
	private String location;
	
	@Column
	private long gstNo;

	public MerchantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MerchantEntity(int id, String name, long pinCode, String location, long gstNo) {
		super();
		this.id = id;
		this.name = name;
		this.pinCode = pinCode;
		this.location = location;
		this.gstNo = gstNo;
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

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getGstNo() {
		return gstNo;
	}

	public void setGstNo(long gstNo) {
		this.gstNo = gstNo;
	}
}

