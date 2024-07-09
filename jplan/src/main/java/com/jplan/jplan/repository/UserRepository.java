package com.jplan.jplan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.User;
import java.util.Set;
import com.jplan.jplan.entity.Project;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    User findByUserEmail(String userEmail);

    boolean existsByUsername(String username);

    boolean existsByUserEmail(String userEmail);

    List<User> findByCompanyId(String companyId);

}
