package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;
import  com.flipkart.bean.GymCenter;

public class GymOwner extends User {

    private String name;
    private String email;
    private String contactNo;
    private int age;
    public List<GymCenter> gymCenters;
    public GymOwner(String username, String name, String email, String contactNo, int age, String password, String id, Role role) {
        super(username, password, id, role);
        this.name=name;
        this.email=email;
        this.contactNo=contactNo;
        this.age=age;
        this.gymCenters=new ArrayList<GymCenter>();
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<GymCenter> getGymCenters() {
        return gymCenters;
    }

    public void setGymCenters(List<GymCenter> gymCenters) {
        this.gymCenters = gymCenters;
    }
}
