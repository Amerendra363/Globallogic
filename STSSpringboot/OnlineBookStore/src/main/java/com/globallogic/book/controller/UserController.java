package com.globallogic.book.controller;

import java.util.List;

import javax.mail.MessagingException;

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
import com.globallogic.book.entity.Order;
import com.globallogic.book.entity.User;
import com.globallogic.book.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	// SHOW LIST OF USERS
	@GetMapping("/")
	public List<User> show() {
		return service.showDetails();
	}

	// ADD USERS
	@PostMapping("/")
	public List<User> addUser(@RequestBody User user) {

		return service.addUser(user);
	}

	// UPDATE USERS
	@PutMapping("/")
	public String updateUser(@RequestBody User User) {

		return service.updateUser(User);
	}

	// DELETE USERS
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return service.delete(id);
	}

	// FORGET PASSWORD
	@GetMapping("/forgetpassword/id/{id}/newpassword/{password}")
	public String forgetPassword(@PathVariable("id") int id, @PathVariable("password") String password) {
		return service.forgetPassword(id, password);
	}

	// CHECK LOGIN
	@GetMapping("/log/userid/{userid}/password/{password}")
	public String loginUser(@PathVariable("userid") String userId, @PathVariable("password") String password) {
		return service.login(userId, password);
	}

	// SEARCH BOOK BY ID
	@GetMapping("/searchbookbyid/id/{id}")
	public Book searchById(@PathVariable("id") int id) {
		return service.searchBookById(id);
	}

	// SEARCH BOOK BY NAME
	@GetMapping("/searchbookbyname/name/{name}")
	public Book searchByName(@PathVariable("name") String name) {
		return service.searchBookByName(name);
	}

	// SEARCH BOOK BY AUTHOR NAME
	@GetMapping("/searchbookbyauthor/name/{name}")
	public List<Book> searchByAuthor(@PathVariable("name") String name) {
		return service.searchBookByAuthor(name);
	}

	// ORDER BOOK AND SEND MAIL
	@GetMapping("/buybook/userid/{userid}/bookid/{bookid}/address/{address}")
	public String buyBook(@PathVariable("userid") String userId, @PathVariable("bookid") int bookId,
			@PathVariable("address") String address) throws MessagingException{

		return service.buyBook(userId, bookId, address);
	}

	// VIEW ORDER HISTORY
	@GetMapping("/history/userid/{userid}")
	public List<Order> viewHistory(@PathVariable("userid") String userId) {

		return service.viewHistory(userId);
	}
}
