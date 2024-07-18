package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.User;

import java.util.HashMap;

import static com.flipkart.business.UserServiceInterface.addUser;

public class CustomerServiceInterface {
    private static int cnt = 1;
    public static HashMap<String, Customer> customers = new HashMap<String, Customer>();

    public static void createCustomer(String username, String name, String email, String phone, int age, String password) {
        String id = "C_" + cnt++;
        Customer customer = new Customer(username, name, email, phone, age, id, password);
        customers.put(id, customer);
        User user = new User(username, name, email, phone, age, password, id);
        addUser(user);
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
