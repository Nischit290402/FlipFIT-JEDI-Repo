package com.flipkart.bean;

import java.time.LocalDateTime;

public class Booking {
    private String userID;
    private String bookingID;
    private String gymID;
    private String slotID;
    private LocalDateTime date;


    public Booking(String userID, String bookingID, String gymID, String slotID, LocalDateTime date) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
        this.date = date;
    }

    public Booking(String userID, String bookingID, String gymID, String slotID) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymID = gymID;
        this.slotID = slotID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getGymID() {
        return gymID;
    }

    public void setGymID(String gymID) {
        this.gymID = gymID;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }
}
