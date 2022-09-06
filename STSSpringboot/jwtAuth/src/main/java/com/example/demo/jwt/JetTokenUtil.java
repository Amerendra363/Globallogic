package com.example.demo.jwt;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.user.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JetTokenUtil {
	private static final long EXPIRE_DURATION=24*60*60*1000;
	@Value("${app.jwt.secret}")
	private String secretKey;
	public String generationAccessToken(User user) {
return Jwts.builder()
		.setSubject(user.getId()+","+user.getEmail())
		.setIssuer("CodeJava")
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis()+EXPIRE_DURATION))
		.signWith(SignatureAlgorithm.HS512,secretKey)
		.compact();
	}
}
