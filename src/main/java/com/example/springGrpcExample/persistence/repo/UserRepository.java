package com.example.springGrpcExample.persistence.repo;

import com.example.springGrpcExample.persistence.record.UsersTRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersTRec, Long> {
    Optional<UsersTRec> findByEmail(String email);
}
