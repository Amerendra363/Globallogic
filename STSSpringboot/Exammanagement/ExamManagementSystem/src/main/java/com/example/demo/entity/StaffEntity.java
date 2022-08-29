package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class StaffEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String Staname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStaname() {
		return Staname;
	}
	public void setStaname(String staname) {
		Staname = staname;
	}
	@Override
	public String toString() {
		return "StaffEntity [id=" + id + ", Staname=" + Staname + "]";
	}
	public StaffEntity(int id, String staname) {
		super();
		this.id = id;
		Staname = staname;
	}
	public StaffEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}


