package com.example.lkoon.movieboja.model;

/**
 * Created by lkoon on 2017-07-11.
 */

public class TheaterCommnents {
    int tag;
    String commnet;
    String id;

    public TheaterCommnents(int tag, String commnet, String id) {
        this.tag = tag;
        this.commnet = commnet;
        this.id = id;
    }

    public TheaterCommnents(int tag) {
        this.tag= tag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommnet() {
        return commnet;
    }


    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }
    @Override
    public String toString() {
        return "TheaterCommnents{" +
                "tag=" + tag +
                ", commnet='" + commnet + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
