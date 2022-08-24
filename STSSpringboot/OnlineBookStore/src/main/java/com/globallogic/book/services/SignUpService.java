package com.globallogic.book.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.globallogic.book.entity.SignUp;

@Component
public interface SignUpService {
	
	//GET
	public List<SignUp> showDetails();
	
	//POST
	public String addSignup(SignUp signUp);
	
	//PUT
	public String updateSignup(SignUp signUp);
	
	//DELETE
	public String delete(int id);

}
