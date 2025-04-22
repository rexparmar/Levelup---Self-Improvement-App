package com.levelup.levelup.dto;

public class AuthErrorResponse extends PlayerCreateResponse{
    private String error;

    public AuthErrorResponse(String error){
        this.error=error;
    }

    public String getMessage() {
        return error;
    }

    public void setMessage(String error) {
        this.error = error;
    }

}
