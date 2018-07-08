package com.example.lkoon.http03.model;

import io.realm.RealmObject;

/**
 * Created by lkoon on 2017-03-25.
 */

public class Word extends RealmObject {
    private String word;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
