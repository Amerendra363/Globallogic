package com.globallogic.helloworld;
import java.util.*;
public class Arrays {
public static void main(String[] args) {
	int arr[]=new int[10];
	//int[] arr=new int[10];
	//int[] arr1={1,2,3};
	//Employee[] arr=new Employee[10];
	arr[0]=1;
	Scanner sc=new Scanner(System.in);
	for(int i=0;i<10;i++)
	{
		arr[i]=sc.nextInt();
		System.out.println(arr[i]);
	}
}
}
