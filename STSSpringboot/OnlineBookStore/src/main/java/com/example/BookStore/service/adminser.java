package com.example.BookStore.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.admin;
@Component
public interface adminser {

	public String admi(admin s);
	public List<admin> showdet();
	public String update(admin s);
	public String delete(long id);
	public String sucessSignin(long id,String email,String pass);
}
