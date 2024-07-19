package com.flipkart.bean;

import java.time.LocalDateTime;

public class Slot {
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private int capacity;
    private String slotID;

    public Slot( String slotID ,LocalDateTime starttime, LocalDateTime endtime, int capacity) {
        this.slotID = slotID;
        this.starttime = starttime;
        this.endtime = endtime;
        this.capacity = capacity;
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
