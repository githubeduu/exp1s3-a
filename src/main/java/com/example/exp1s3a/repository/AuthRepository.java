package com.example.exp1s3a.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp1s3a.model.Auth;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByUsernameAndPassword(String username, String password);
}
