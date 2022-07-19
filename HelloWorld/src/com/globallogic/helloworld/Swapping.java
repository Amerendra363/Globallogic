//Java program for swapping two numbers

package com.globallogic.helloworld;
import java.util.*;
public class Swapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("Values before swapping a= "+a+" and b= "+b);
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println("Values after swapping a= "+a+ " and b= "+b );

	}

}
