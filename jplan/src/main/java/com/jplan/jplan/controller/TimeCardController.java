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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jplan.jplan.entity.TimeCard;
import com.jplan.jplan.models.requests.TimeCardRequest;
import com.jplan.jplan.models.response.MessageResponse;
import com.jplan.jplan.service.TimeCardService;
import com.jplan.jplan.service.UserService;
import com.jplan.jplan.utils.UtilsJwt;

@RestController
@RequestMapping("/timecard")
@CrossOrigin("http://localhost:3005")
public class TimeCardController {

    @Autowired
    private TimeCardService tcService;

    @Autowired
    private UserService userService;

    @Autowired
    private UtilsJwt utilsJwt;

    // @GetMapping("/tmp")
    // public void createSecureTimeCard(@RequestBody TimeCardRequest
    // timeCardRequest,
    // @RequestHeader(value = "Authorization") String token) throws Exception {
    // System.out.println(token);

    // }

    @PostMapping()
    public ResponseEntity<?> createTimeCard(@RequestBody TimeCardRequest tcRequest,
            @RequestHeader(value = "Authorization") String token) {
        System.out.println(tcRequest.toString());
        tcRequest.setUsername(utilsJwt.getUsernameFromJwt(token));
        tcService.saveTimeCard(tcRequest);
        return ResponseEntity.ok(new MessageResponse("New time card created"));
    }

    @GetMapping("/{username}")
    public Optional<List<TimeCard>> userTimeCards(@PathVariable String username) {
        return tcService.getByUsername(username);
    }

    @GetMapping("")
    public Optional<List<TimeCard>> userTimeCards2(@RequestParam("username") String username,
            @RequestHeader(value = "Authorization") String token) {
        boolean hasAuth = userService.checkUserAuthorieties(username, "MARCIN");

        if (hasAuth) {
            System.out.println("Welcome " + username);
        } else {
            System.out.println("You shouldn't be here " + username);
        }
        return tcService.getByUsername(username);
    }

    @GetMapping("/active")
    public Optional<List<TimeCard>> getMethodName(@RequestParam("username") String username) {
        return tcService.getActiveCardsByUsername(username);
    }

}
