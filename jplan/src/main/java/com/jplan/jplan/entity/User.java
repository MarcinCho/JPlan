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
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_date_created")
    @CreationTimestamp
    private Date userDateCreated;

    @Column(name = "user_name")
    private String userName;

    public User() {
    }

    public User(String userId, String firstName, String lastName, String companyId, String userEmail, int roleId,
            String userPassword) {
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
        this.userEmail = userEmail;
        this.roleId = roleId;
        this.userPassword = userPassword;
    }

}
