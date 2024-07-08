package com.jplan.jplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jplan.jplan.entity.User;
import com.jplan.jplan.entity.UserDetailsImp;
import com.jplan.jplan.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("Can't find the user :" + username);
            throw new UsernameNotFoundException("User " + username + "not found");
        }
        System.out.println(user);

        return new UserDetailsImp(user);
    }

}
