package com.example.exp1s3a.service;

import com.example.exp1s3a.model.Auth;

public interface AuthService {
    boolean validatePassword(String username, String password);
    Auth createAuth(Auth auth); 
}