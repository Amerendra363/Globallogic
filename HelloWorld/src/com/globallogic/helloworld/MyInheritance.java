package com.globallogic.helloworld;
//Single inheritance
class A {
	int id=10;
	public void printA() {
		System.out.println("A");

	}

}

class B extends A{
		public void printB() {
		System.out.println("B");
		System.out.println(super.id);
		
	}

}

class c {

}

public class MyInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a.printA();
		B b=new B();
		b.printB();
		b.printA();
		System.out.println(b.id);
		
		
		

	}

}
