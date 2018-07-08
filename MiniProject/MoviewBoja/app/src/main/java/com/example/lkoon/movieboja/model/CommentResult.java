package com.example.lkoon.movieboja.model;

import java.util.List;

/**
 * Created by lkoon on 2017-09-01.
 */

public class CommentResult {

    int result;
    String message;
    List<TheaterCommnents> data;

    public CommentResult(int result, String message, List<TheaterCommnents> data) {
        this.result = result;
        this.message = message;
        this.data = data;
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

    public List<TheaterCommnents> getData() {
        return data;
    }

    public void setData(List<TheaterCommnents> data) {
        this.data = data;
    }
}
