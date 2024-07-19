package com.flipkart.bean;

import java.util.*;
public class GymCenter {
    private String gymID;
    private String gymName;
    private String address;
    private String city;
    
    private Map<String, GymCenter> gymCentres = new HashMap<>(); 
    private Map<String, GymCenter> pendingCentres = new HashMap<>();
    public GymCenter() {}
    public GymCenter(String gymID, String gymName, String address, String city) {}
    public String getGymID() {
        return gymID;
    }

    public void setGymID(String gymID) {
        this.gymID = gymID;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Map<String, GymCenter> getApprovedGyms() {
        return gymCentres;
    }

    public Map<String, GymCenter> getPendingGyms() {
        return pendingCentres;
    }
}
