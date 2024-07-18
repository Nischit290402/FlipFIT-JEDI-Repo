package com.flipkart.bean;

public class User {
    private String username;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String password;
    private String id;
    public User(String username, String name, String email, String phone, int age, String password, String id){
        this.username=username;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.age=age;
        this.password=password;
        this.id=id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return phone;
    }

    public void setContactNo(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
