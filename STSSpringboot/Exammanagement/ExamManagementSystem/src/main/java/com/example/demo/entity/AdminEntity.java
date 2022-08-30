package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String Adname;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	List<ExamEntity> exam;
	
	
	
	
	public List<ExamEntity> getExam() {
		return exam;
	}
	public void setExam(List<ExamEntity> exam) {
		this.exam = exam;
	}
	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", Adname=" + Adname + "]";
	}
	public AdminEntity(int id, String aname) {
		super();
		this.id = id;
		this.Adname = aname;
	}
	public AdminEntity(int id, String adname, List<ExamEntity> exam) {
		super();
		this.id = id;
		this.Adname = adname;
		this.exam = exam;
	}
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdname() {
		return Adname;
	}
	public void setAdname(String adname) {
		this.Adname = adname;
	}
	



}
