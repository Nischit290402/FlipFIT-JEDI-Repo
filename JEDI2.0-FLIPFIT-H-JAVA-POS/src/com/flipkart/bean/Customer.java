package com.flipkart.bean;
public class Customer extends User {
    private String name;
    private String email;
    private String phone;
    private int age;

    public Customer(String username, String Name, String Email, String contactNo, int age, String password, String ID, Role role) {
        super(username, password, ID, role);
        this.name = Name;
        this.email = Email;
        this.phone = contactNo;
        this.age = age;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
