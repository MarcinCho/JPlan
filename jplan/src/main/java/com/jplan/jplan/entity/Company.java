package com.jplan.jplan.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    // @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch =
    // FetchType.EAGER)
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "company_id")
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "companyProjects", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JoinColumn(name = "company_id")
    private List<Project> projects;

    // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinTable(name = "project", joinColumns = @JoinColumn(name = "company_id"),
    // inverseJoinColumns = @JoinColumn(name = "project_id"))
    // private Set<Project> projects = new HashSet<>();

    @Override
    public String toString() {
        return "Company [id=" + id + ", companyName=" + companyName + ", companyEmail=" + companyEmail
                + ", dateCreated=" + dateCreated + "]";
    }

    // , cascade = CascadeType.ALL, fetch = FetchType.LAZY

    // public Company() {
    // }

    // public Company(String id, String comapanyName, String companyEmail) {
    // this.id = UUID.randomUUID().toString();
    // this.companyName = comapanyName;
    // this.companyEmail = companyEmail;
    // // this.users = users;
    // }

}
