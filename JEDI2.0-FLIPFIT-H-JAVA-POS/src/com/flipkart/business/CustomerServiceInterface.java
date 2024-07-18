package com.flipkart.business;

import com.flipkart.bean.Customer;
import java.util.Scanner;
import com.flipkart.bean.User;

import java.util.HashMap;

import static com.flipkart.business.UserServiceInterface.addUser;

public class CustomerServiceInterface {
	private static int cnt = 1;
	public static HashMap<String, Customer> customers = new HashMap<String, Customer>();

	public static void createCustomer(String username, String name, String email, String phone, int age,
			String password) {
		String id = "C_" + cnt++;
		Customer customer = new Customer(username, name, email, phone, age, id, password);
		customers.put(id, customer);
		User user = new User(username, name, email, phone, age, password, id);
		addUser(user);
		System.out.println("Customer created");
	}

	public static void showProfile(String id) {
		Customer customer = customers.get(id);
		if (customer != null) {
			System.out.println("Username: " + customer.getUsername());
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Phone: " + customer.getContactNo());
			System.out.println("Age: " + customer.getAge());
			System.out.println("ID: " + customer.getID());
		} else {
			System.out.println("Customer not found.");
		}
	}

	public static void viewBookings() {

	}

//    public static void editProfile() {
//    	
//    }
	public static void editProfile(User user) {

		Scanner scanner = new Scanner(System.in);

		Customer customer = customers.get(user.getID());

		if (customer != null) {

			boolean updating = true;

			while (updating) {
				System.out.println("Choose the field to update:");
				System.out.println("1. Username");
				System.out.println("2. Name");
				System.out.println("3. Email");
				System.out.println("4. Phone");
				System.out.println("5. Age");
				System.out.println("6. Password");
				System.out.println("7. Exit");

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Enter new username:");
					customer.setUsername(scanner.nextLine());
					break;
				case 2:
					System.out.println("Enter new name:");
					customer.setName(scanner.nextLine());
					break;
				case 3:
					System.out.println("Enter new email:");
					customer.setEmail(scanner.nextLine());
					break;
				case 4:
					System.out.println("Enter new phone:");
					customer.setContactNo(scanner.nextLine());
					break;
				case 5:
					System.out.println("Enter new age:");
					customer.setAge(Integer.parseInt(scanner.nextLine()));
					break;
				case 6:
					System.out.println("Enter new password:");
					customer.setPassword(scanner.nextLine());
					break;
				case 7:
					updating = false;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			}
			System.out.println("Customer profile updated.");
		} else {
			System.out.println("Customer not found.");
		}

	}
}
