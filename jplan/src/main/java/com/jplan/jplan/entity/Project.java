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
@Table(name = "project")
@Data
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "company_id")
    private String companyId;

    @CreationTimestamp
    @Column(name = "project_start")
    private Date startDate;

    @Column(name = "project_stop")
    private Date stopDate;

    @Column(name = "description")
    private String description;

    public Project() {
    }

    public Project(String projectId, String projectName, String companyId, Date startDate, Date stopDate,
            String description) {
        this.projectId = UUID.randomUUID().toString();
        this.projectName = projectName;
        this.companyId = companyId;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.description = description;
    }

}
