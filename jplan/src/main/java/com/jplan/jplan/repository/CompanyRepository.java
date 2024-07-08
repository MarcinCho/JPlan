package com.jplan.jplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
