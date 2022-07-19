package com.globallogic.helloworld;

class Person{  
int id;    
Person(int id){  
this.id=id;  
  
}  
}  
class Emp extends Person{  
int salary;  
Emp(int id,int salary){  
super(id);
this.salary=salary;  
}  
void display(){System.out.println(id+" "+" "+salary);}  
}  
class useofsuper{  
public static void main(String[] args){  
Emp e1=new Emp(1,45000);  
e1.display();  
}
}  






