package com.globallogic.helloworld;

class person
{
	public void work() {
		System.out.println("work");
	}
}
class School extends person
{
	public void work() {
		System.out.println("School");
	}
}
public class mypolymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person R=new person();
		R.work();
		R=new School();
		R.work();

	}

}
