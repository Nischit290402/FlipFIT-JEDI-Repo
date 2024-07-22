package com.flipkart.bean;

public class User {
    private String username;
    private String password;
    private String userid;
    private String roleId;
    public User(String username, String password, String id, String roleId){
        this.username=username;
        this.password=password;
        this.userid =id;
        this.roleId =roleId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRole(String roleId) {
        this.roleId = roleId;
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
