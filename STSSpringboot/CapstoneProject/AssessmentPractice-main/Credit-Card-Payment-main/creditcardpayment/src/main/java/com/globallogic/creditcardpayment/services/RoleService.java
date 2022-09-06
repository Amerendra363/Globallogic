package com.globallogic.creditcardpayment.services;

import java.util.List;

import com.globallogic.creditcardpayment.entity.Role;

public interface RoleService {
	//private RoleRepo Reol;
	public List<Role> getRole();
	public void createNewRole(Role role);
//	{
//	return Reol.save(role);	
//	}

}
