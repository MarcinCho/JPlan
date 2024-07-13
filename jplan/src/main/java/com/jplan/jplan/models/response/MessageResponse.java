package com.jplan.jplan.models.response;

public class MessageResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
