package com.example.mobile_labs_20521247;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    String username;
    String fullname;
    String phone;
    String password;

    public User(String username, String fullname, String phone, String password) {
        this.fullname = fullname;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
