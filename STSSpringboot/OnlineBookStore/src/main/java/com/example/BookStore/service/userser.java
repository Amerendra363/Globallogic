package com.example.BookStore.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.BookStore.entity.user;
@Component
public interface userser {

public String sucessSignin(long id,String email,String pass);
public String use(user s);
public List<user> showdet();
public String update(user s);
public String delete(long id);
}
