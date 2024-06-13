package com.jplan.jplan.entity;

import java.util.Date;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_product")
    private String id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "creation_date")
    @CreationTimestamp
    private Date date;

    public Product() {
    }

    public Product(String productName, Date date) {
        this.id = UUID.randomUUID().toString();
        this.productName = productName;
        this.date = date;
    }

}
