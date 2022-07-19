package com.globallogic.helloworld;

public class bike {
	private int regno;
	private String model;
	private int price;
	

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

		public String toString()
	{
		return this.model;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bike b=new bike();
		b.setRegno(786);
		b.setModel("R15V3");
		b.setPrice(170000);
		System.out.println("Registration no -"+b.getRegno());
		System.out.println("Model="+b.getModel());
		System.out.println("Price= "+b.getPrice());

	}

}
