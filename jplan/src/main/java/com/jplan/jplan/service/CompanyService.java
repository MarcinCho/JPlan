package com.jplan.jplan.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jplan.jplan.entity.User;
import com.jplan.jplan.entity.Company;
import com.jplan.jplan.repository.CompanyRepository;

public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // void printUsers(Company company) {
    // for (User user : company.getUsers()) {
    // System.out.println(user.getUsername());
    // }
    // }

}
