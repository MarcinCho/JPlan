package com.jplan.jplan.entity;

import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "time_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tc_id")
    private String tcId;

    @Column(name = "username")
    private String username;

    @CurrentTimestamp
    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "stop_time")
    private Date stopTime;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "edited")
    private Boolean edited;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "comment")
    private String comment;

}
