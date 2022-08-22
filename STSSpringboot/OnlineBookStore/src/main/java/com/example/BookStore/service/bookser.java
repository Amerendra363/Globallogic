package com.example.BookStore.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.book;
@Component
public interface bookser {

public String addbook(book bk);
public List<book>display();
public String update(book s);
public String delete(long id);

}
