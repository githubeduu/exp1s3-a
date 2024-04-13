package com.example.exp1s3a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp1s3a.model.Auth;
import com.example.exp1s3a.repository.AuthRepository;

@Service
public class AuthServicelmpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public boolean validatePassword(String username, String password) {
     
        Auth auth = authRepository.findByUsernameAndPassword(username, password);
        
        return auth != null;
    }

    @Override
    public Auth createAuth(Auth auth){
        return authRepository.save(auth);
    }
}
