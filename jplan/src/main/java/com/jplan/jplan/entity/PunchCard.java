package com.jplan.jplan.entity;

import java.util.Date;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "punch_card")
@Data
public class PunchCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pc_id")
    private String pcId;

    @Column(name = "user_id")
    private String userId;

    @CurrentTimestamp
    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "stop_time")
    private Date stopTime;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "edited")
    private Boolean edited;

}
