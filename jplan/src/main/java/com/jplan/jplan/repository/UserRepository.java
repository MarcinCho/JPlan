package com.jplan.jplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    User findByUserEmail(String userEmail);
}
