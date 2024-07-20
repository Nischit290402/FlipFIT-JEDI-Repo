package com.flipkart.bean;

import java.time.LocalDateTime;
import java.util.*;
public class GymCenter {
    private String gymID;
    private String gymName;
    private String address;
    private String city;
    private List<Slot> slots;
//    private Map<String, GymCenter> gymCentres = new HashMap<>();
//    private Map<String, GymCenter> pendingCentres = new HashMap<>();
    public GymCenter(String gymID, String gymName, String address, String city, List<Slot> slots) {
        this.gymID = gymID;
        this.gymName = gymName;
        this.address = address;
        this.city = city;
        this.slots=slots;
    }

    public String addSlot(String id, LocalDateTime st, LocalDateTime et, int capacity){
        for(Slot sl:slots){
            if(sl.getStarttime()==st){
                return "Slot already exists.";
            }
        }
        Slot slot=new Slot(id, st, et, capacity, new ArrayList<Booking>(), new ArrayList<Booking>());
        slots.add(slot);
        return "Slot added successfully.";
    }

    public String removeSlot(LocalDateTime st){
        for(Slot sl:slots){
            if(sl.getStarttime()==st){
                slots.remove(sl);
                return "Slot removed successfully.";
            }
        }
        return "Slot doesn't exist to remove.";
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

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
//    public Map<String, GymCenter> getApprovedGyms() {
//        return gymCentres;
//    }
//
//    public Map<String, GymCenter> getPendingGyms() {
//        return pendingCentres;
//    }
}
