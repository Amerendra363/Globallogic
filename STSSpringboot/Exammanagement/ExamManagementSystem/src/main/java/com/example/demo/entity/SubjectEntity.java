package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="subject")
public class SubjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String Subname;
	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectEntity(int id, String subname) {
		super();
		this.id = id;
		Subname = subname;
	}
	@Override
	public String toString() {
		return "SubjectEntity [id=" + id + ", Subname=" + Subname + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubname() {
		return Subname;
	}
	public void setSubname(String subname) {
		Subname = subname;
	}

}
