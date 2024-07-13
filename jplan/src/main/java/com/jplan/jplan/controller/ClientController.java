package com.jplan.jplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jplan.jplan.entity.Company;
import com.jplan.jplan.service.CompanyService;

@RestController
@CrossOrigin("http://localhost:3005")
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(@RequestHeader(value = "Authorization") String token) {
        System.out.println(token);
        return companyService.findAllCompanies();
    }

}
