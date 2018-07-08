package com.example.lkoon.movieboja.model;

import java.util.List;

/**
 * Created by lkoon on 2017-06-24.
 */

public class ChatRoom
{

    private List<ChatData> list;

    public ChatRoom(){

    }

    public ChatRoom( List<ChatData> list) {

        this.list = list;
    }

    public List<ChatData> getList() {
        return list;
    }

    public void setList(List<ChatData> list) {
        this.list = list;
    }
}
