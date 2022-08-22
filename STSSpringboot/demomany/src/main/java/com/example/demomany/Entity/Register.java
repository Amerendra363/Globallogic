package com.example.demomany.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column
	long rollNo;
	
	@Column
	double fees;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(long id, long rollNo, double fees) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.fees = fees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", rollNo=" + rollNo + ", fees=" + fees + "]";
	}
	
	

}