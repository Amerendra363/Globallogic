package com.globallogic.helloworld;
class Empl {
	int emp_id, salary;
	String name, designation, email;
	static String loc=" Noida";
	
	//Getter and setters for getting and setting properties  
	public int getEmp_id() {  
	    return emp_id;  
	}  
	public void setEmp_id(int emp_id) {  
	    this.emp_id = emp_id;  
	}  
	public int getSalary() {  
	    return salary;  
	}  
	public void setSalary(int salary) {  
	    this.salary = salary;  
	}  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  	
	public String getDesignation() {  
	    return designation;  
	}  
	public void setDesignation(String designation) {  
	    this.designation = designation;  
	}  
	public String getEmail() {  
	    return email;  
	}  
	public void setEmail(String email) {  
	    this.email = email;  
	}
	
	@Override
	public String toString() {
		return "EmployeeDetails [emp_id=" + emp_id + ", salary=" + salary + ", name=" + name + ", designation="
				+ designation + ", email=" + email + " location ="+loc+
				"]";
	}  
}

//Creating main class  
public class E{  
  //main() method start  
  public static void main(String args[]) {  
        
      //Creating object of EmployeeDetails class  
      Empl emp = new Empl();  
      //Setting values to the properties  
      emp.setEmp_id(2527097);  
      
      emp.setName("Amerendra Kumar");  
      emp.setDesignation("SE");  
      emp.setSalary(40000);  
      emp.setEmail("amerendra.kumar@globallogic.com");  
        
      //Showing Employee details  
      System.out.println(emp);  
        
            
  }  
}


