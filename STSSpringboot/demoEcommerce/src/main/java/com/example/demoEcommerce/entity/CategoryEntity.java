package com.example.demoEcommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
@Entity 
@Table(name="category")

public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column
	private String cat;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", cat=" + cat + "]";
	}


	public CategoryEntity(int id, String cat) {
		super();
		this.id = id;
		this.cat = cat;
	}


	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
