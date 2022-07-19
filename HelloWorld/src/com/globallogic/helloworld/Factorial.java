//Java program to calculate a Factorial of a number
package com.globallogic.helloworld;
import java.util.*;
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int j=1;
		for(int i=n;i>1;i--)
			j=j*i;
		System.out.print(j);

	}

}
