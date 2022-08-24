package com.globallogic.book.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.globallogic.book.entity.Admin;
import com.globallogic.book.entity.Book;

@Component
public interface AdminService {
	
	//POST-->LOGIN success
	public String login(Admin admin);
	
	//GET-->
	public List<Admin> details();
	
	//get login
	public String loginSecondWay(String userId,String password);
	
	//POST admin details
	public List<Admin> addAdmin(Admin admin);
	
	//PUT
	public String updateAdmin(Admin admin);
	
	//DELETE
	public String delete(int id);
	
	//forgetPassword   //GET
	public String forgetPassword(int id,String newPassword);
	
	//Add book  //POST
	public List<Book> addBook(Book book);
	
	//Update book  //PUT 
	public List<Book> updateBook(Book book);
	
	//Active Book    //GET
	public List<Book> activeBook();
	
	//InActive Book    //GET
	public List<Book> inactiveBook();
	
	
	
	

}
