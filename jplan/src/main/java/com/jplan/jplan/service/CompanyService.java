package com.jplan.jplan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jplan.jplan.entity.Company;
import com.jplan.jplan.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    };

    public Optional<Company> findById(String Id) {
        return companyRepository.findById(Id);
    };

}
