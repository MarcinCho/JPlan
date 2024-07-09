package com.jplan.jplan.config.payload;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class TimeCardRequest {

    private String username;

    @CreationTimestamp
    private Date start_time;

    private boolean active;

    private boolean edited;

    private String projectId;
}
