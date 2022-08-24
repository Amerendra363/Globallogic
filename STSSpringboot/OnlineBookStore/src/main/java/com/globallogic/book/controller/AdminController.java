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

import com.globallogic.book.entity.Admin;
import com.globallogic.book.entity.Book;
import com.globallogic.book.services.AdminService;
import com.globallogic.book.services.SignUpService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService service;

	
	// VIEW ALL ADMIN
	@GetMapping("/")
	public List<Admin> showAdmin(Admin admin) {
		return service.details();
	}

	
	// ADD ADMIN DETAILS
	@PostMapping("/")
	public List<Admin> addAdmin(@RequestBody Admin admin) {
		return service.addAdmin(admin);
	}
	
	
	// CHECK LOGIN
	@PostMapping("/login")
	public String loginAdmin(@RequestBody Admin admin) {
		return service.login(admin);
	}

	// CHECK LOGIN SECOND WAY
	@GetMapping("/log/userid/{userid}/password/{password}")
	public String loginAdminSecondWay(@PathVariable("userid") String userId, @PathVariable("password") String password) {
		return service.loginSecondWay(userId, password);
	}


	// UPDATE ADMIN DETAILS
	@PutMapping("/")
	public String updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}

	// FORGET PASSWORD
	@GetMapping("/forgetpassword/id/{id}/newpassword/{password}")
	public String forgetPassword(@PathVariable("id") int id, @PathVariable("password") String password) {
		return service.forgetPassword(id, password);
	}

	// DELETE ADMIN
	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable("id") int id) {

		return service.delete(id);
	}

	// ADD BOOK
	@PostMapping("/addbook")
	public List<Book> addBook(@RequestBody Book book) {

		return service.addBook(book);
	}

	// UPDATE BOOK
	@PutMapping("/updatebook")
	public List<Book> updateBook(@RequestBody Book book) {

		return service.updateBook(book);
	}

	// ACTIVE BOOKS
	@GetMapping("/activebook")
	public List<Book> activeBook() {

		return service.activeBook();
	}

	//INACTIVE BOOKS
	@GetMapping("/inactivebook")
	public List<Book> inactiveBook() {

		return service.inactiveBook();
	}

}
