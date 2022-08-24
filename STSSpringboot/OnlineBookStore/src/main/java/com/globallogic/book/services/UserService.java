package com.globallogic.book.services;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import com.globallogic.book.entity.Book;
import com.globallogic.book.entity.Order;
import com.globallogic.book.entity.User;


@Component
public interface UserService {
	
	    //GET
		public List<User> showDetails();
		
		//get login
		public String login(String email,String password);
		
		//forgetPassword   //GET
		public String forgetPassword(int id,String newPassword);
		
		//POST
		public  List<User> addUser(User user);
		
		//PUT
		public String updateUser(User user);
		
		//DELETE
		public String delete(int id);
		
		//SEARCH BOOK BY ID
		public Book searchBookById(int id);
		
		//SEARCH BOOK BY NAME
		public Book searchBookByName(String name);
		
		//SEARCH BOOK BY AUTHOR NAME
		public List<Book> searchBookByAuthor(String name);
		
		
		//BUY BOOK AND SEND MAIL
		public String buyBook(String userId,int bookId,String address) throws MessagingException;
		
		//VIEW ORDER HISTORY
		public List<Order> viewHistory(String userId);
	

}