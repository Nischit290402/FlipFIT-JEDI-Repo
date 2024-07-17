package com.flipkart.bean;

public class User {
    private String username;
    private String Name;
    private String Email;
    private String contactNo;
    private int age;
    private String password;
    private String ID;
    public User(String username, String Name, String Email, String contactNo, int age, String password, String ID){
        this.username=username;
        this.Name=Name;
        this.Email=Email;
        this.contactNo=contactNo;
        this.age=age;
        this.password=password;
        this.ID=ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
