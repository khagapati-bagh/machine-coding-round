package com.udaan.models;

import java.util.UUID;

public class User {
    private String userId;
    private String userName;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
