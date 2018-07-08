package com.example.lkoon.movieboja.model;

/**
 * Created by lkoon on 2017-03-17.
 */

public class User {

    String id;
    String passwd;
    String name;
    String email;
    String phone;

    public User(String name) {
        this.id = id;
    }

    public User(String id, String passwd){
        this.id = id;
        this.passwd=passwd;
    }

    public User(String id, String passwd, String name, String phone, String email) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", passwd='" + passwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
