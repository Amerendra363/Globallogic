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
@Table(name="result")
public class ResultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	int Eid;
	@Column
	String Rstatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getRstatus() {
		return Rstatus;
	}
	public void setRstatus(String rstatus) {
		Rstatus = rstatus;
	}
	@Override
	public String toString() {
		return "ResultEntity [id=" + id + ", Eid=" + Eid + ", Rstatus=" + Rstatus + "]";
	}
	public ResultEntity(int id, int eid, String rstatus) {
		super();
		this.id = id;
		Eid = eid;
		Rstatus = rstatus;
	}
	public ResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
