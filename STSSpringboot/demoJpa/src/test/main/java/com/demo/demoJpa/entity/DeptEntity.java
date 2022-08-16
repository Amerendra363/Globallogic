package com.demo.demoJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="dept")

public class DeptEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

@Column
String name;
@Column
String location;


public DeptEntity(int id, String name, String location) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
}
public DeptEntity() {
	
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "DeptEntity [id=" + id + ", name=" + name + ", location=" + location + "]";
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
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
