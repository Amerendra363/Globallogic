package com.globallogic.book.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.globallogic.book.entity.Book;

@Component
public interface BookService {
	
	    //GET
		public List<Book> showDetails();
		
		//POST
		public  List<Book> addBook(Book book);
		
		//PUT
		public String updateBook(Book book);
		
		//DELETE
		public String delete(int id);
	

}
