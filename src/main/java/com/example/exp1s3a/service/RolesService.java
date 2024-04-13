package com.example.exp1s3a.service;

import java.util.Optional;

import com.example.exp1s3a.model.Roles;

public interface RolesService {
    Optional<Roles> getRolesById(Long id);
}
