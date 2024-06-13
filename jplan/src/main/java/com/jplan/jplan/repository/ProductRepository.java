package com.jplan.jplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jplan.jplan.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
