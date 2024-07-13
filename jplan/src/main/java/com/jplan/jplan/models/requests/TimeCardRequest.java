package com.jplan.jplan.models.requests;

import java.sql.Date;

import lombok.Data;

@Data
public class TimeCardRequest {

    private String username;

    private Date start_time;

    private Date stop_time;

    private boolean active;

    private boolean edited;

    private String projectId;

    private String comment;
}
