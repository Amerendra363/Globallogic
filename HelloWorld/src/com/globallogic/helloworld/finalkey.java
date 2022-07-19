package com.globallogic.helloworld;


//final
class Base
{
	final int id=10;
	//final 
	public void printA()
	{
		System.out.println("A");
	}
}
class child extends Base
{
	public void printA()
	{
		System.out.println("B");
		//System.out.println();
	}
}

public class finalkey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
