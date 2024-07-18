package com.flipkart.bean;

public class GymOwner extends User {
    private String name;
    private String email;
    private String contactNo;
    private int age;
    public GymOwner(String username, String name, String email, String contactNo, int age, String password, String id, Role role) {
        super(username, password, id, role);
        this.name=name;
        this.email=email;
        this.contactNo=contactNo;
        this.age=age;
    }


}
