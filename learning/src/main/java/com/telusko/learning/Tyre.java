package com.telusko.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tyre {
	@Autowired
	private String brand;

	@Override
	public String toString() {
		return "Its working";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
