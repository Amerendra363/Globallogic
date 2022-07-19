//write a program to give the color code and print the color name  //switch
package com.globallogic.helloworld;
import java.util.*;
public class Colorif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the color code");
		int n=sc.nextInt();
		if(n==1)
			System.out.println("RED");
		else if(n==2)
			System.out.println("BLUE");
		else 
			System.out.println("Code not found");

	}

}
