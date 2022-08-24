package com.globallogic.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.book.entity.Book;
import com.globallogic.book.repository.BookRepo;
import com.globallogic.book.services.BookService;

@Component
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepo repoBook;
	
	@Override
	public List<Book> showDetails() {
		// TODO Auto-generated method stub
		return repoBook.findAll();
	}

	@Override
	public List<Book> addBook(Book book) {
		repoBook.save(book);
		return repoBook.findAll();
	}

	@Override
	public String updateBook(Book book) {
		repoBook.save(book);
		return "Book updated successfully";
	}

	@Override
	public String delete(int id) {
		repoBook.deleteById(id);
		return "Book Deleted Successfully";
	}
}
