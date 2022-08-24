package com.globallogic.book.serviceImpl;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.book.email.EmailSenderService;
import com.globallogic.book.entity.Admin;
import com.globallogic.book.entity.Book;
import com.globallogic.book.entity.Order;
import com.globallogic.book.entity.SignUp;
import com.globallogic.book.entity.User;
import com.globallogic.book.repository.BookRepo;
import com.globallogic.book.repository.OrderRepo;
import com.globallogic.book.repository.SignUpRepo;
import com.globallogic.book.repository.UserRepo;
import com.globallogic.book.services.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repoUser;
	
	@Autowired
	BookRepo repoBook;
	
	@Autowired
	SignUpRepo signRepo;
	
	@Autowired
	OrderRepo repoOrder;
	
	@Autowired
	EmailSenderService email;
	
	//SHOW USER DETAILS
	@Override
	public List<User> showDetails() {
		return repoUser.findAll();
	}

	//ADD USERS
	@Override
	public List<User> addUser(User user) {
		repoUser.save(user);
		return repoUser.findAll();
	}

	//UPDATE USERS
	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		signRepo.save(user.getSignUp());
		repoUser.save(user);
		return "User Updated Successfully";
	}

	//DELETE USERS
	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		User user = repoUser.findById(id).get();
		repoUser.deleteById(id);
		signRepo.deleteById(user.getSignUp().getId());
		return "User deleted successfully";
	}

	//SEARCH BOOK BY ID
	@Override
	public Book searchBookById(int id) {
		return repoBook.findById(id).get();
	}

	//SEARCH BOOK BY NAME
	@Override
	public Book searchBookByName(String name) {
		return repoBook.findByName(name);
	}
	
	
	//SEARCH BOOK BY AUTHOR NAME
	@Override
	public List<Book> searchBookByAuthor(String name) {
		return repoBook.findByAuthor(name);
	}

	
	//CHECK LOGIN THROUGH URL
	@Override
	public String login(String userId, String password) {
		List<SignUp> signList = signRepo.findByUserIdAndPasswordAndType(userId,password,"USER");		
		if(!signList.isEmpty()) {
			return "LOGIN SUCCESSFULLY";
		}
		return "INVALID EMAIL OR PASSWORD";
	}

	
	//FORGOT PASSWORD
	@Override
	public String forgetPassword(int id, String newPassword) {
		
		User user = repoUser.findById(id).get();
		
		int checkid = user.getSignUp().getId();
		System.out.println(checkid);
		System.out.println(signRepo.findById(checkid).get());
		signRepo.setPasswordForSignup(newPassword, checkid);

		return "Password Set Successfully";
	}

	
	//BUY BOOK AND SEND MAIL
	@Override
	public String buyBook(String userId, int bookId, String address) throws MessagingException {
		
		Order o = new Order();
		o.setIdUser(userId);
		o.setIdBook(bookId);
		o.setShippingAddress(address);
		repoOrder.save(o);
		
		//Changing status of book to sold
		repoBook.setStatusForBook("SOLD", bookId);
		
		//sending mail
		email.sendSimpleEmail("gav.singh0011@gmail.com",           
				"Order Placed Successfully",
				"Order Placed");
		
		//to take the mail id by default
//		 SignUp sign = signRepo.findByUserId(userId);
//		 String emails = sign.getEmail();
//		 email.sendSimpleEmail(emails,           
//					"Order Placed Successfully",
//					"Order Placed");
		
		return "ORDER PLACED SUCCESSFULLY";
	}

	//VIEW ORDER HISTORY
	@Override
	public List<Order> viewHistory(String userId) {
		return repoOrder.getOrderByIdUser(userId);
	}

}
