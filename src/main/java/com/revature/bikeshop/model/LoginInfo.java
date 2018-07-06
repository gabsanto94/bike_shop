package com.revature.bikeshop.model;

public class LoginInfo {

    private User user;

    public LoginInfo() {
        super();
    }

    public LoginInfo(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "user=" + user +
                '}';
    }
}
