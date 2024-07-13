package com.jplan.jplan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jplan.jplan.entity.User;
import com.jplan.jplan.entity.UserDetailsImp;
import com.jplan.jplan.models.requests.LoginRequest;
import com.jplan.jplan.models.requests.RegisterRequest;
import com.jplan.jplan.models.response.JwtResponse;
import com.jplan.jplan.models.response.MessageResponse;
import com.jplan.jplan.repository.RoleRepository;
import com.jplan.jplan.repository.UserRepository;
import com.jplan.jplan.service.UserService;
import com.jplan.jplan.utils.UtilsJwt;

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

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userRepo.existsByUsername(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        if (userRepo.existsByUserEmail(registerRequest.getUserEmail())) {
            return ResponseEntity.badRequest().body("Email is already connected to other account :(");
        }

        User user = new User(registerRequest.getUsername(), registerRequest.getPassword(), null, null,
                registerRequest.getUserEmail(), null, null, null, null);

        service.saveUser(user);

        return ResponseEntity.ok(new MessageResponse("Added user"));

    }
}
