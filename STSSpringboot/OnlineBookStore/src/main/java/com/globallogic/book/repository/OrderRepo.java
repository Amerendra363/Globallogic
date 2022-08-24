package com.globallogic.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.globallogic.book.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
	

	public List<Order> getOrderByIdUser(String idUser);
	
	
//	@Query("Select e from EmployeeDemo e where e.sname=:name and e.ssalary=:salary")
//	public List<EmployeeDemo> getEmployeeBySnameAndSsalary(String name, double salary);
	
}
