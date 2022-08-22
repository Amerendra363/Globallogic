package com.example.BookStore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookStore.entity.Signup;
import com.example.BookStore.entity.user;
import com.example.BookStore.repo.UserRepo;
import com.example.BookStore.service.signinser;
import com.example.BookStore.service.userser;

@Component
class userImpl implements userser{
@Autowired
UserRepo usre;

@Autowired
signinser serv;

	@Override
	public String use(user s) {
		// TODO Auto-generated method stub
		usre.save(s);
		return "Data Added";
	}

	@Override
	public List<user> showdet() {
		// TODO Auto-generated method stub
		return usre.findAll();
	}

	@Override
	public String update(user s) {
		// TODO Auto-generated method stub
		usre.save(s);
		return "Data Updated";
	}

	@Override
	public String delete(long id) {
		// TODO Auto-generated method stub
		usre.deleteById(id);
		return "Data Deleted";
	}

	@Override
	public String sucessSignin(long id, String email, String pass) {
		// TODO Auto-generated method stub
		List<Signup> sign = serv.showdet();
		for (Signup s : sign) {
			System.out.println("i am in for");
			System.out.println(s);
			if (s.getId() == id && s.getEmail().equals(email) && s.getPass().equals(pass)) {
				System.out.println("i am in if");
				return "Login Success";
			}
		}
		return "invalid login";
	}
	


	}


