package com.flipkart.business;

import com.flipkart.bean.Customer;

public class CustomerBusiness {
    public void createCustomer() {
        System.out.println("Customer created");
    }
    public boolean updateCustomer(int CustomerID) {
        System.out.println("Customer updated by ID --> " + CustomerID);
        return true;
    }
    public boolean deleteCustomer(int CustomerID) {
        System.out.println("Customer deleted by ID --> " + CustomerID);
        return true;
    }
    public void listCustomers() {
        System.out.println("Customer list");
    }
}
