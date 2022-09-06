package com.example.demo.user.api;

public class AuthRes {
    private String email;
    private String accessToken;
 
    public AuthRes() { }
     
    public AuthRes(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }
 
    // getters and setters are not shown...
}