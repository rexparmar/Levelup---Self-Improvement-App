package com.levelup.levelup.dto;

import com.levelup.levelup.model.Player;

public class PlayerCreateResponse {
    private String message;
    private String token;

    public PlayerCreateResponse(){}

    public PlayerCreateResponse(String message, String token){
        this.message=message;
        this.token=token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
