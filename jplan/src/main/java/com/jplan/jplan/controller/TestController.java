package com.jplan.jplan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello user with sesion id: " + request.getSession().getId();
    }

}