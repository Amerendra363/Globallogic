package com.globallogic.book.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.globallogic.book.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	
	
	public Book findByName(String name);
	
	
	public List<Book> findByAuthor(String name);
	
	@Modifying
	@Transactional
	@Query("update Book b set b.status = :status where b.id = :id")
	public void setStatusForBook(String status,int id);
	

}
