package com.jplan.jplan.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id")
    private String id;

    @NonNull
    @Column(name = "company_name")
    private String companyName;

    @NonNull
    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "companyProjects", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;

    @Override
    public String toString() {
        return "Company [id=" + id + ", companyName=" + companyName + ", companyEmail=" + companyEmail
                + ", dateCreated=" + dateCreated + "]";
    }

}
