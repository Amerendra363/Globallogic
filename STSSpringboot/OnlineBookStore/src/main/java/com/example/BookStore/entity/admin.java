package com.example.BookStore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Admin")
public class admin {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
long id;
@Column
String name; 
@Column
long phone;
@ManyToMany(cascade=CascadeType.PERSIST)
List<book> us;
@OneToOne(cascade=CascadeType.PERSIST)
Signup s;
public admin(long id, String name, long phone, List<book> us, Signup s) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.us = us;
	this.s = s;
}
public admin() {
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
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public List<book> getUs() {
	return us;
}
public void setUs(List<book> us) {
	this.us = us;
}
public Signup getS() {
	return s;
}
public void setS(Signup s) {
	this.s = s;
}
@Override
public String toString() {
	return "admin [id=" + id + ", name=" + name + ", phone=" + phone + ", us=" + us + ", s=" + s + "]";
}

}
