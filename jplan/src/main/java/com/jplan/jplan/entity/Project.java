package com.jplan.jplan.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company companyProjects;

    @CreationTimestamp
    @Column(name = "project_start")
    private Date startDate;

    // @CreationTimestamp
    @Column(name = "project_stop")
    private Date stopDate;

    @Column(name = "description")
    private String description;

    // public Project() {
    // }

    // public Project(String projectName, String companyId, Date startDate, Date
    // stopDate,
    // String description) {
    // // this.projectId = UUID.randomUUID().toString();
    // this.projectName = projectName;
    // this.companyId = companyId;
    // this.startDate = startDate;
    // this.stopDate = stopDate;
    // this.description = description;
    // }

}
