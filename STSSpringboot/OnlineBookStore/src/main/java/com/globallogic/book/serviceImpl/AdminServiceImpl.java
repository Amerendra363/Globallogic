package com.globallogic.book.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.book.entity.Admin;
import com.globallogic.book.entity.Book;
import com.globallogic.book.entity.SignUp;
import com.globallogic.book.repository.AdminRepo;
import com.globallogic.book.repository.BookRepo;
import com.globallogic.book.repository.SignUpRepo;
import com.globallogic.book.services.AdminService;
import com.globallogic.book.services.BookService;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	SignUpRepo signRepo;
	
	@Autowired
	AdminRepo repoAdmin;
	
	@Autowired
	BookRepo repoBook;
	
	//admin find all admins
	@Override
	public List<Admin> details() {
		return repoAdmin.findAll();
	}
	
	//Admin add details
	@Override
	public List<Admin> addAdmin(Admin admin) {
		repoAdmin.save(admin);
		return repoAdmin.findAll();
	}
	
	//ADMIN LOGIN
	@Override
	public String login(Admin admin) {
		
		List<SignUp> signList = signRepo.findByUserIdAndPasswordAndType(admin.getSignUp().getUserId(),
				admin.getSignUp().getPassword(),admin.getSignUp().getType());		
		if(!signList.isEmpty()) {
			return "LOGIN SUCCESSFULLY";
		}
		return "INVALID EMAIL OR PASSWORD";
	}
	
	//ADMIN LOGIN SECONDWAY
	public String loginSecondWay(String userId, String password) {
		
		List<SignUp> signList = signRepo.findByUserIdAndPasswordAndType(userId,password,"ADMIN");		
		if(!signList.isEmpty()) {
			return "LOGIN SUCCESSFULLY";
		}
		return "INVALID EMAIL OR PASSWORD";
	}
	

	//Admin edit details
	@Override
	public String updateAdmin(Admin admin) {
		signRepo.save(admin.getSignUp());
		repoAdmin.save(admin);
		return "ADMIN DETAILS UPDATED SUCCESSFULLY";
	}

	//Admin delete details
	@Override
	public String delete(int id) {
		
		Admin admin = repoAdmin.findById(id).get();
		int idSign = admin.getSignUp().getId();
		repoAdmin.deleteById(id);
		signRepo.deleteById(idSign);
		return "ADMIN DELETED SUCCESFULLY";
	}

	//password set successfully
	@Override
	public String forgetPassword(int id,String newPassword) {
		
		Admin admin = repoAdmin.findById(id).get();
	
		int checkid = admin.getSignUp().getId();
		System.out.println(checkid);
		System.out.println(signRepo.findById(checkid).get());
		signRepo.setPasswordForSignup(newPassword, checkid);

		return "Password Set Successfully";
	
	}

	//Add Book
	@Override
	public List<Book> addBook(Book book) {
		repoBook.save(book);
		return repoBook.findAll();
	}	
	
	//Update Book
	@Override
	public List<Book> updateBook(Book book) {
		repoBook.save(book);
		return repoBook.findAll();
	}	
	
	//Find Active Book
	@Override
	public List<Book> activeBook(){
		List<Book> active = new ArrayList<>();
		for(Book b:repoBook.findAll()) {
			if(b.getStatus().equalsIgnoreCase("Active")) {
				active.add(b);
			}
		}
		return active;
	}

	//Find InActive Book
	@Override
	public List<Book> inactiveBook() {
		List<Book> inactive = new ArrayList<>();
		for(Book b:repoBook.findAll()) {
			if(b.getStatus().equalsIgnoreCase("Inactive")) {
				inactive.add(b);
			}
		}
		return inactive;
	}

}
