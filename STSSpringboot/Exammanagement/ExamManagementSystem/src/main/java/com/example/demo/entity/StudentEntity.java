package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String Sname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", Sname=" + Sname + "]";
	}
	public StudentEntity(int id, String sname) {
		super();
		this.id = id;
		Sname = sname;
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
