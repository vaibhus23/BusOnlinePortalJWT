package com.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entities.AdminUser;

@Repository
public interface UserRepository extends JpaRepository<AdminUser, Integer>{
  public Optional<AdminUser> findByUserName(String userName);
  public boolean existsByEmail(String email);
  public boolean existsByUserName(String userName);
}
