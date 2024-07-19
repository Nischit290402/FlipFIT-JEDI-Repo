package com.flipkart.dao;
public interface CustomerDAO {

    public void fetchBookedSlots(String customerId);
    public void cancelBooking(String GymId ,String slotId, String userId, String date);


}
