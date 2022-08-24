package com.globallogic.book.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globallogic.book.entity.SignUp;

public interface SignUpRepo extends JpaRepository<SignUp, Integer> {

	public List<SignUp> findByUserIdAndPasswordAndType(String userId, String password, String type);

//
//	@Modifying
//	@Query("Update signup set password =:newPassword where signup.id=:id")
//	public boolean setForgetPassword(String newPassword, int id);
	
	public SignUp findByUserId(String userId);
	
	
	@Modifying
	@Transactional
	@Query("update SignUp s set s.password = :password where s.id = :id")
	public void setPasswordForSignup(String password,int id);


}
