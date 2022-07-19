package com.globallogic.helloworld;

import java.util.Scanner;

class PositiveNumber extends Exception
{
	public PositiveNumber(String msg)
	{
		super(msg);
	}
}
public class Mycusexception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		//int n=sc.nextInt();
		try(Scanner scanner=new Scanner(System.in))
		{
			System.out.println("enter the number");
			int n=scanner.nextInt();
		if(n > 0)			
		{
			throw new PositiveNumber("Enter Only Positive Number");
		}
		}
		catch(Exception e)
		{
			//TODO: HANDLE EXCEPTION
			
		}
		finally {
			System.out.println("end");
		}


	}
}


