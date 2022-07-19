package com.globallogic.helloworld;




class A1{
	public void printA()
	{
		System.out.println("A1");
	}
}
class B1 extends A1{
	public void printB() {
	System.out.println("B1");
}
}
class C1 extends B1{
	public void printC() {
	System.out.println("C1");
}
}
public class Multilevelinheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C1 c=new C1();
		c.printA();
		c.printB();
		c.printC();

	}

}
