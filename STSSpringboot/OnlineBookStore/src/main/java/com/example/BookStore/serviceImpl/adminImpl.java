package com.example.BookStore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookStore.entity.Signup;
import com.example.BookStore.entity.admin;
import com.example.BookStore.repo.AdminRepo;
import com.example.BookStore.service.adminser;
import com.example.BookStore.service.signinser;

@Component
public class adminImpl implements adminser {
	@Autowired
	AdminRepo adr;
	@Autowired
	signinser serv;

	@Override
	public String admi(admin s) {
		// TODO Auto-generated method stub
		adr.save(s);
		return "Data Admin Added";
	}

	@Override
	public List<admin> showdet() {
		// TODO Auto-generated method stub
		return adr.findAll();
	}

	@Override
	public String update(admin s) {
		// TODO Auto-generated method stub
		adr.save(s);
		return "Data Admin updated";
	}

	@Override
	public String delete(long id) {
		// TODO Auto-generated method stub
		adr.deleteById(id);
		return "Data deleted of admin";
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
