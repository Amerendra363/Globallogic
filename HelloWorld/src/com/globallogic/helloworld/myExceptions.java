package com.globallogic.helloworld;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class myExceptions {
	public void exce()throws FileNotFoundException
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Arethmetic Exception
		// divide by zero
		int a=10;
		int b=0;
		//int c=a/b;
		//System.out.println("c is "+c);
		//null pointer exception
		String str=null;
		//System.out.println(str.charAt(10));
		//arrayindexoutofbound
		int arr[]=new int[2];
		//System.out.println(arr[5]);
		
		//checked exception
		try
		{
		FileInputStream ft=new FileInputStream("c:\\java.txt");
		}
		catch(Exception e)
		{
			System.out.println();
		}
		finally {
			System.out.println("I am final");
		}
	}

}
