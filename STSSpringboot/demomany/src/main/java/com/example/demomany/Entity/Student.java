package com.example.demomany.Entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column
	String name;
	
	@Column
	String city;
	
	//ONE TO ONE MAPPING WITH REGISTER TABLE
	@OneToOne(cascade = CascadeType.PERSIST)
	Register register;
	
	
	//ONE TO MANY MAPPING WITH ADDRESS TABLE
	//With Many mapping take list
	@OneToMany(cascade = CascadeType.PERSIST)
	List<Address> address;
	
	//MANY TO MANY MAPPING WITH ADDRESS TABLE
	@ManyToMany(cascade = CascadeType.PERSIST)
	List<Teacher> teacher;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id, String name, String city, Register register, List<Address> address, List<Teacher> teacher) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.register = register;
		this.address = address;
		this.teacher = teacher;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", register=" + register + ", address="
				+ address + ", teacher=" + teacher + "]";
	}
	
}