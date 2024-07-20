package com.flipkart.dao;

import com.flipkart.bean.Booking;

public interface CustomerDAO {

    public void fetchBookedSlots(String customerId);
    public void cancelBooking(String GymId ,String slotId, String userId, String date);
    public void addBooking(Booking booking);

}
