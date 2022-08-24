package com.globallogic.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.book.entity.Book;
import com.globallogic.book.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/")
	public List<Book> show(){
		return service.showDetails();
	}
	
	@PostMapping("/")
	public List<Book> addSignUp(@RequestBody Book book) {
		
		return service.addBook(book);
		
	}
	
	@PutMapping("/")
	public String updateSignUp(@RequestBody Book book) {
		
		return service.updateBook(book);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteSignUp(@PathVariable("id") int id) {
		return service.delete(id);
	}

}
