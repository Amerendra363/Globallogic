package com.globallogic.creditcardpayment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="RoleId")
	long id;
	@Column(name="RoleName")
	private String roleName;
	@Column(name="roleD")
	private String roleDescription;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	public Role(long id, String roleName, String roleDescription) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
}
