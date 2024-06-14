package com.jplan.jplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
