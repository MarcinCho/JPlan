package com.jplan.jplan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jplan.jplan.config.payload.MessageResponse;
import com.jplan.jplan.config.payload.TimeCardRequest;
import com.jplan.jplan.entity.TimeCard;
import com.jplan.jplan.service.TimeCardService;

@RestController
@RequestMapping("/timecard")
@CrossOrigin("http://localhost:3005")
public class TimeCardController {

    @Autowired
    private TimeCardService tcService;

    @PostMapping()
    public ResponseEntity<?> createTimeCard(@RequestBody TimeCardRequest tcRequest) {
        TimeCard timeCard = new TimeCard(null, tcRequest.getUsername(), tcRequest.getStart_time(), null, true, false,
                tcRequest.getProjectId());
        tcService.savePunchCard(timeCard);
        return ResponseEntity.ok(new MessageResponse("New time card created"));
    }

    @GetMapping("/{username}")
    public Optional<List<TimeCard>> userTimeCards(@PathVariable String username) {
        return tcService.getByUsername(username);
    }

    @GetMapping("")
    public Optional<List<TimeCard>> userTimeCards2(@RequestParam("username") String username) {
        return tcService.getByUsername(username);
    }

    @GetMapping("/active")
    public Optional<List<TimeCard>> getMethodName(@RequestParam("username") String username) {
        return tcService.getActiveCardsByUsername(username);
    }

}
