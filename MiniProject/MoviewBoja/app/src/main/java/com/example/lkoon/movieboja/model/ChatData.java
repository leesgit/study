package com.example.lkoon.movieboja.model;

/**
 * Created by lkoon on 2017-06-24.
 */

public class ChatData {

    private String username;
    private String message;

    public ChatData(String message) {
        this.message = message;
    }

    public ChatData(){

    }
    public ChatData(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
