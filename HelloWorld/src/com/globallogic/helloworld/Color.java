//write a program to give the color code and print the color name  //switch 
package com.globallogic.helloworld;
import java.util.*;
public class Color {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the color code");
		String s=sc.next();
		switch(s)
		{
		case "#FF0000":
			System.out.println("RED");
			break;
		case "#0000FF":
			System.out.println("BLUE");
			break;
		default:
			System.out.println("Color not found");
			break;

		
		}

	}

}
