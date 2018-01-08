package com.example.lbc.mfcproject.data;

/**
 * Created by lbc on 2017-11-30.
 */

public class Id {
    String id;
    int point;

    public Id(String id) {
        this.id = id;
    }

    public Id(String id, int point) {
        this.id = id;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
