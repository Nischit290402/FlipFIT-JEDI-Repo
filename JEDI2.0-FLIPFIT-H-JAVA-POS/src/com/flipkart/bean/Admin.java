package com.flipkart.bean;

public class Admin extends User {
    public Admin(String username, String name, String email, String contactNo, int age, String password, String id, String roleId) {
        super(username, password, id, roleId);
    }
}
