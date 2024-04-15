package com.example.exp1s3a.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp1s3a.model.Roles;
import com.example.exp1s3a.repository.RolesRepository;

@Service
public class RolesServicelmpl implements RolesService {
    @Autowired
    private RolesRepository rolRepository;    

    @Override
    public List<Roles> getAllRoles(){
        return rolRepository.findAll();
    }
    @Override
    public Optional<Roles> getRolesById(Long id){
        return rolRepository.findById(id);
    }

}
