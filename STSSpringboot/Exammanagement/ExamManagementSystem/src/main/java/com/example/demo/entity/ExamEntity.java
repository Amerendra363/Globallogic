package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="exam")
public class ExamEntity {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String Ename;
	@Column
	String Subject;
	@Column
	String Course;
	@Column
	String stream;
	@Column
	String NoQ;
	@Column
	int time;
	@Column
	String Estatus;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	List<AdminEntity> admin;
	
	
	
	
	public List<AdminEntity> getAdmin() {
		return admin;
	}
	public void setAdmin(List<AdminEntity> admin) {
		this.admin = admin;
	}

	
	public ExamEntity(int id, String ename, String subject, String course, String stream, String noQ, int time,
			String estatus, List<AdminEntity> admin) {
		super();
		this.id = id;
		Ename = ename;
		Subject = subject;
		Course = course;
		this.stream = stream;
		NoQ = noQ;
		this.time = time;
		Estatus = estatus;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getNoQ() {
		return NoQ;
	}
	public void setNoQ(String noQ) {
		NoQ = noQ;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getEstatus() {
		return Estatus;
	}
	public void setEstatus(String estatus) {
		Estatus = estatus;
	}
	@Override
	public String toString() {
		return "ExamEntity [id=" + id + ", Ename=" + Ename + ", Subject=" + Subject + ", Course=" + Course + ", stream="
				+ stream + ", NoQ=" + NoQ + ", time=" + time + ", Estatus=" + Estatus + ", admin=" + admin + "]";
	}
	public ExamEntity(int id, String ename, String subject, String course, String stream, String noQ, int time,
			String estatus) {
		super();
		this.id = id;
		Ename = ename;
		Subject = subject;
		Course = course;
		this.stream = stream;
		NoQ = noQ;
		this.time = time;
		Estatus = estatus;
	}
	public ExamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
