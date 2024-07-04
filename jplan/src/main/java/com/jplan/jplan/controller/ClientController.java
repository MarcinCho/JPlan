package com.jplan.jplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.jplan.jplan.entity.Company;
import com.jplan.jplan.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private CompanyRepository company;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(@RequestParam(required = false) String title) {
        return company.findAll();
    }
}
