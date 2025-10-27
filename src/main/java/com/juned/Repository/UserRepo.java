package com.juned.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juned.Entity.User_entity;

@Repository
public interface UserRepo extends JpaRepository<User_entity, Long> {
Optional<User_entity> findByEmail(String email);
boolean existsByEmail(String email);
}
