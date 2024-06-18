package com.example.springGrpcExample.core;

import com.example.springGrpcExample.domain.Users;
import com.example.springGrpcExample.persistence.record.UsersTRec;

import java.util.Optional;

public interface UsersService {
    Optional<UsersTRec> findById(Long id);
    Optional<Users> findByEmail(String email);
    void save(Users user);
    void deleteById(Long id);
}
