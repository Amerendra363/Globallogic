package com.globallogic.EmployeeServices.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {
	
	
	 public EmployeeEntity()
	{
		
	}
	
	public EmployeeEntity(long id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", salary=" + salary + "]";
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	long id;
	
	@Column
	String name;
	
	@Column
	double salary;

}