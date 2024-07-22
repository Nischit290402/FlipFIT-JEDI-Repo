package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String name;
    private String email;
    private String phone;
    private int age;
    private List<pair<Booking, Boolean>> bookings;
    public Customer(String username, String Name, String Email, String contactNo, int age, String password, String ID, String roleID, List<Booking> bookings) {
        super(username, password, ID, roleID);
        this.name = Name;
        this.email = Email;
        this.phone = contactNo;
        this.age = age;
        this.bookings= new ArrayList<pair<Booking, Boolean>>();
    }

    public List<pair<Booking, Boolean>> getBookings() {
        return bookings;
    }

    public void setBookings(List<pair<Booking, Boolean>> bookings) {
        this.bookings = bookings;
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
