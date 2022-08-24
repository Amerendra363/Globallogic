package com.globallogic.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.book.entity.SignUp;
import com.globallogic.book.repository.SignUpRepo;
import com.globallogic.book.services.SignUpService;

@Component
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	SignUpRepo signRepo;


	@Override
	public List<SignUp> showDetails() {
		return signRepo.findAll();
	}

	@Override
	public String addSignup(SignUp signUp) {
		String type = signUp.getType();
		String comment="";
		if(type.equalsIgnoreCase("admin"))
		{
			comment = "Admin Registered Successfully";
		}
		else if(type.equalsIgnoreCase("user"))
		{
			comment = "User Registered Successfully";
		}
		signRepo.save(signUp);
		return comment;
	}

	@Override
	public String updateSignup(SignUp signUp) {
		String type = signUp.getType();
		String comment="";
		if(type.equalsIgnoreCase("admin"))
		{
			comment = "Admin Updated Successfully";
		}
		else if(type.equalsIgnoreCase("user"))
		{
			comment = "User Updated Successfully";
		}
		signRepo.save(signUp);
		return comment;
	}

	@Override
	public String delete(int id) {
		signRepo.deleteById(id);
		return "DATA DELETED SUCCESSFULLY";
	}

}
