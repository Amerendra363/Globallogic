package com.globallogic.helloworld;


class Employee {

	int id;
	String name;
	static String cityName;
	
	static class dept
	{
		int dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Employee(int id, String name, String cityName) {
		super();
	}
}

		
public class statickey {

	public static void main(String[] args) {
		//
		Employee ravinder = new Employee(1001, "ravinder", "delhi");
		ravinder.setName("ravinder");

		System.out.println(ravinder);

		Employee kumar = new Employee(1002, "kumar", "chennai");

		System.out.println(ravinder);
		System.out.println(kumar);
		ravinder = kumar;
		// able to access with the class name
		//Employee.print();
		
		Employee.dept dept=new Employee.dept();
		
	}
}

