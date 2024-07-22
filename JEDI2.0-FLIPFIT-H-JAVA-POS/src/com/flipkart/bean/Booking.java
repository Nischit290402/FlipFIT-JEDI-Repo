package com.flipkart.bean;

import java.time.LocalDateTime;
// Represents a booking made by a user at a gym center.

public class Booking {
    // Unique identifier of the user making the booking.
    private String userID;

    // Unique identifier for this booking.
    private String bookingID;

    // The gym center where the booking is made.
    private GymCenter gymCenter;

    // The start time of the booking.
    private LocalDateTime starttime;

    /* Constructor to initialize a Booking object.
    Parameters:
       userID: ID of the user making the booking.
       bookingID: Unique ID for this booking.
       gymCenter: GymCenter object representing the gym where booking is made.
       starttime: LocalDateTime object representing the start time of the booking.
     */
    public Booking(String userID, String bookingID, GymCenter gymCenter, LocalDateTime starttime) {
        this.userID = userID;
        this.bookingID = bookingID;
        this.gymCenter = gymCenter;
        this.starttime = starttime;
    }

    // Getter for userID.
    public String getUserID() {
        return userID;
    }

    // Setter for userID.
    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getter for BookingID.
    public String getBookingID() {
        return bookingID;
    }

    // Setter for BookingID.
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    // Getter for gymCenter.
    public GymCenter getGymCenter() {
        return gymCenter;
    }

    // Setter for gymCenter.
    public void setGymCenter(GymCenter gymCenter) {
        this.gymCenter = gymCenter;
    }

    // Getter for starttime.
    public LocalDateTime getStarttime() {
        return starttime;
    }

    // Setter for starttime.
    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }
}
