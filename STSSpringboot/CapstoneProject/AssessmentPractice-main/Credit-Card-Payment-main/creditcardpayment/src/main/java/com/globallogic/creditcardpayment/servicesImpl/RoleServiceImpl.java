package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Role;
import com.globallogic.creditcardpayment.repositories.RoleRepo;
import com.globallogic.creditcardpayment.services.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepo roleRepo;
	
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	
	public void createNewRole(Role role)
	{
		roleRepo.save(role);
	}

}
