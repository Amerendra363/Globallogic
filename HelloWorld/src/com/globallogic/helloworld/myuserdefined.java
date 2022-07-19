package com.globallogic.helloworld;

enum Days{
	MON,TUE,WED,THU,FRI,SAT,SUN
}
public class myuserdefined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Days.MON);
		System.out.println(Days.TUE);
		System.out.println("V"+Days.valueOf("MON"));
		//for(Days.valueOf(null, null))
		for(Days d:Days.values())
		{System.out.println(d);

	}
	}
	
}
