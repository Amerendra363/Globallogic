package com.example.BookStore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookStore.entity.Signup;
import com.example.BookStore.repo.signinRepo;
import com.example.BookStore.service.signinser;
@Component
public class SigninImpl implements signinser{
@Autowired
signinRepo repo;

@Override
public String signin(Signup s) {
	// TODO Auto-generated method stub
	repo.save(s);
	return "Signin Successfull";
}

@Override
public List<Signup> showdet() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

@Override
public String update(Signup s) {
	// TODO Auto-generated method stub
	repo.save(s);
	return "Update Successfull";
}

@Override
public String delete(long id) {
	// TODO Auto-generated method stub
	repo.deleteById(id);
	return "Data deleted";
}
	
}
