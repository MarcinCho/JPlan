package com.jplan.jplan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jplan.jplan.config.jwt.UtilsJwt;
import com.jplan.jplan.config.payload.JwtResponse;
import com.jplan.jplan.config.payload.LoginRequest;
import com.jplan.jplan.entity.User;
import com.jplan.jplan.entity.UserDetailsImp;
import com.jplan.jplan.repository.RoleRepository;
import com.jplan.jplan.repository.UserRepository;
import com.jplan.jplan.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3005")
@RequestMapping("/auth")
public class AuthorizationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UtilsJwt utilsJwt;

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('MODERATOR') or hasAuthority('GLOBAL_ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = utilsJwt.generateJwtToken(authentication);

        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(),
                roles));
    }

    @PostMapping("/register/user")
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/register")
    public String postMethodNme(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    @GetMapping("token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello user with sesion id: " + request.getSession().getId();
    }

}
