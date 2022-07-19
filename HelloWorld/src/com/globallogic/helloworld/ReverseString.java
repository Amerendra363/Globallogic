//Java Program to reverse the letters present in the given String
package com.globallogic.helloworld;
import java.util.*;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String s=sc.nextLine();
		int l=s.length();
		for(int i=l-1;i>=0;i--)
			System.out.print(s.charAt(i));

	}

}
