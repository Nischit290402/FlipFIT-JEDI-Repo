package com.flipkart.bean;

public class User {
    private String username;
    private String password;
    private String userid;
    private Role role;
    public User(String username, String password, String id, Role role){
        this.username=username;
        this.password=password;
        this.userid =id;
        this.role =role;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
