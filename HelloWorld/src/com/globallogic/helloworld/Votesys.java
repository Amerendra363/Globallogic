//Write a program to vote system if age is > 18 allow to cast a vote

package com.globallogic.helloworld;
import java.util.*;
public class Votesys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the age");
		int a=sc.nextInt();
		if(a>=18)
			System.out.println("You are allowed to vote");
		else
			System.out.println("You are not allowed to vote");		

	}

}
