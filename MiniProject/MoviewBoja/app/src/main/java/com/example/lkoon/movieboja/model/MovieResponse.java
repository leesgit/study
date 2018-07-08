package com.example.lkoon.movieboja.model;

import java.util.List;

/**
 * Created by jwk on 2017. 6. 22..
 */

public class MovieResponse {
    private int count;
    private List<MovieData> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MovieData> getData() {
        return data;
    }

    public void setData(List<MovieData> data) {
        this.data = data;
    }
}
