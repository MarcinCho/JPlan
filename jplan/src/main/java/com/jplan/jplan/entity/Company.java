package com.jplan.jplan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name")
    private String comapanyName;

    @Column(name = "email")
    private String email;

    public Company() {
    }

    public Company(Long id, String comapanyName, String email) {
        this.id = id;
        this.comapanyName = comapanyName;
        this.email = email;
    }

}