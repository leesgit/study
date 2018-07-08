package com.example.lkoon.movieboja.model;

/**
 * Created by lkoon on 2017-03-31.
 */

public class SimpleResult {
    int result;
    String message;

    public SimpleResult(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
