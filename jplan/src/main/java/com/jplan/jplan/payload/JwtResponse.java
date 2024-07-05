package com.jplan.jplan.payload;

import java.util.List;
import java.util.Base64;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String info = Base64.getEncoder().encodeToString("TajemnaWiadomoscOdSerweraJplan".getBytes());
    private List<String> roles;

    public JwtResponse(String accessToken, String username, List<String> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        String info = "a cos tam jakos nie wiem";
    }

}
