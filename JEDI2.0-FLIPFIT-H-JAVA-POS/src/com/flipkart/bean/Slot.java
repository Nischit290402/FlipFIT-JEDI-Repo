package com.flipkart.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Slot {
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private int capacity;
    private String slotID;
    private List<Booking> bookings;
    private List<Booking> waitings;
    public Slot( String slotID, LocalDateTime starttime, LocalDateTime endtime, int capacity, List<Booking> bookings, List<Booking> waitings) {
        this.slotID = slotID;
        this.starttime = starttime;
        this.endtime = endtime;
        this.capacity = capacity;
        this.bookings=new ArrayList<Booking>();
        this.waitings=new ArrayList<Booking>();
    }

    public List<Booking> getWaitings() {
        return waitings;
    }

    public void setWaitings(List<Booking> waitings) {
        this.waitings = waitings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public void reduceCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void increaseCapacity() {
        capacity++;
    }


}
