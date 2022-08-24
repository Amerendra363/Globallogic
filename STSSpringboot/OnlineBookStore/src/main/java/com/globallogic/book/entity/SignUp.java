package com.globallogic.book.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="signup")
public class SignUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String email;
	
	@Column
	String userId;
	
	@Column
	String password;
	
	@Column
	String type;

	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUp(int id, String email, String userId, String password, String type) {
		super();
		this.id = id;
		this.email = email;
		this.userId = userId;
		this.password = password;
		this.type = type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SignUp [id=" + id + ", email=" + email + ", userId=" + userId + ", password=" + password + ", type="
				+ type + "]";
	}
	

	

	

}
