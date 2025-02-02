package com.globallogic.creditcardpayment.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	long id;
//	
	@Id
	@Column
	String userName;
//	
//	@Column
//	String password;
//
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public User(long id, String userId, String password) {
//		super();
//		this.id = id;
//		this.userId = userId;
//		this.password = password;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", userId=" + userId + ", password=" + password + "]";
//	}
	
	
	
	
	//private String userName;
	
	private String userPassword;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	 @JoinTable(name = "USERS_ROLE",
     joinColumns = {
             @JoinColumn(name = "USERS_ID")
     },
     inverseJoinColumns = {
             @JoinColumn(name = "ROLE_ID")
     }
)
private Set<Role> role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	

	
	

}
