package com.flipkart.business;

import com.flipkart.bean.User;

public interface CustomerServiceInterface {
    public void createCustomer(String username, String name, String email, String phone, int age,
                                      String password);
    public void showProfile(String id);
    void viewBookings(String customerId);
    void cancelBookings(String userId);
    public void editProfile(User user);

}
