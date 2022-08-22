package com.example.BookStore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookStore.entity.book;
import com.example.BookStore.repo.BookRepo;
import com.example.BookStore.service.bookser;

@Component
public class bookImpl implements bookser {
@Autowired
BookRepo br;
	@Override
	public String addbook(book bk) {
		// TODO Auto-generated method stub
		br.save(bk);
		return "Data added successfully";
	}
@Override
	public List<book> display() {
		// TODO Auto-generated method stub
		return br.findAll();
		}
@Override
public String update(book s) {
	// TODO Auto-generated method stub
	br.save(s);
	return "Data Updated";
}
@Override
public String delete(long id) {
	// TODO Auto-generated method stub
	br.deleteById(id);
	return "Data deleted";
}
}
