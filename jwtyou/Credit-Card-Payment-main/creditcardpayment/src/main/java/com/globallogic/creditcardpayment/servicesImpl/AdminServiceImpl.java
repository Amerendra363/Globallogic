package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Admin;
import com.globallogic.creditcardpayment.entity.User;
import com.globallogic.creditcardpayment.repositories.AdminRepo;
import com.globallogic.creditcardpayment.repositories.UserRepo;
import com.globallogic.creditcardpayment.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AdminRepo adminRepo;
	

	@Override
	public String adminLogin(String id, String password) {
		List<User> user = userRepo.findAll();
		
		for(User u : user) {
			if(u.getUserName().equalsIgnoreCase(id) && u.getUserPassword().equalsIgnoreCase(password)) {
				return "ADMIN LOGIN SUCCESSFULL";
			}
		}
		return "INVALID USERID OR PASSWORD";
	}
	
	
	@Override
	public List<Admin> addAdmin(Admin admin) {
		adminRepo.save(admin);
		return adminRepo.findAll();
	}


	@Override
	public List<Admin> showAdmin() {
		return adminRepo.findAll();
	}


	@Override
	public Admin updateAdmin(Admin admin) {
		userRepo.save(admin.getUser());
		adminRepo.save(admin);
		return admin;
	}


	@Override
	public String deleteAdmin(long id) {
		Admin admin = adminRepo.findById(id).get();
		adminRepo.deleteById(id);
		userRepo.deleteById(admin.getUser().getUserName());
		return "ADMIN DELETED SUCCESSFULLY";
	}

}
