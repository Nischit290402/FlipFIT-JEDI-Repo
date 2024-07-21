package com.flipkart.bean;

import java.time.LocalDateTime;

public class Booking {
    private String userID;
    private String bookingID;
    private GymCenter gymCenter;
    private LocalDateTime starttime;

    public Booking(String userID, String bookingID, GymCenter gymCenter, LocalDateTime starttime) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymCenter = gymCenter;
        this.starttime = starttime;
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

    public GymCenter getGymCenter() {
        return gymCenter;
    }

    public void setGymCenter(GymCenter gymCenter) {
        this.gymCenter = gymCenter;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }
}
