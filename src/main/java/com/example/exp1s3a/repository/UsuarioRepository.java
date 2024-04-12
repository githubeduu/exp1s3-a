package com.example.exp1s3a.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp1s3a.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
