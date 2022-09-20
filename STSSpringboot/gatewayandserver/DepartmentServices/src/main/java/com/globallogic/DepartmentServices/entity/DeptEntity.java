package com.globallogic.DepartmentServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class DeptEntity {
	
	
	@Override
	public String toString() {
		return "DeptEntity [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	public DeptEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeptEntity(long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	long id;
	
	@Column
	String name;
	
	@Column
	String location;
	
	

}