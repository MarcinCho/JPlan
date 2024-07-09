package com.jplan.jplan.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jplan.jplan.entity.Project;
import com.jplan.jplan.entity.User;
import com.jplan.jplan.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Set<Project> getUserProjects(User user) {
        return user.getProjects();
    }

}
