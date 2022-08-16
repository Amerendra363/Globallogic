package com.dependency.Injection;

import java.util.List;
import java.util.Set;

public class Employee {
	int id;
	String name;
	List<String> address;
	Set<String> mobile;
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
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public Set<String> getMobile() {
		return mobile;
	}
	public void setMobile(Set<String> mobile) {
		this.mobile = mobile;
	}
	protected Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected Employee(int id, String name, List<String> address, Set<String> mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	
	

}
