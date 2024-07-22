package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.utils.sharedState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import static com.flipkart.utils.dbutils.getTableCnt;

public class CustomerService implements CustomerServiceInterface{
//	private int cnt = getTableCnt("user");
	public HashMap<String, Customer> customers = new HashMap<String, Customer>();
	UserService userService=new UserService();
	GymOwnerService gymOwnerService=new GymOwnerService();
	Scanner scanner = new Scanner(System.in);

	public void createCustomer(String username, String name, String email, String phone, int age,
                                      String password) {
		String id = "0" + sharedState.getCntUsers();
		sharedState.incrementCntUsers();
		Role role = new Role("C", "Customer");
		List<Booking> bookings = new ArrayList<Booking>();
		Customer customer = new Customer(username, name, email, phone, age, password, id, role.getRoleID(), bookings);
		customers.put(id, customer);
		User user = new User(username, password, id, role.getRoleID());
		userService.addUser(user);
		UserDAOImpl userDAO = new UserDAOImpl();
		boolean val1 = userDAO.addUser(user);
		boolean val2 = userDAO.registerCustomer(customer);
		if(val1 && val2){
			System.out.println("Customer created");
		}
		else System.out.println("Customer creation failed");
	}

	public void showProfile(String id) {
		Customer customer = customers.get(id);
		if (customer != null) {
			System.out.println("Username: " + customer.getUsername());
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Phone: " + customer.getPhone());
			System.out.println("Age: " + customer.getAge());
		} else {
			System.out.println("Customer not found.");
		}
	}

	public void viewbookings(String userid) {
		List<pair<Booking, Boolean>> bl=customers.get(userid).getBookings();
		int c=1;
		for(pair<Booking, Boolean> bll:bl){
			System.out.println(c+". Gym Name: "+bll.getFirst().getGymCenter().getGymName()+", Slot Time: "+bll.getFirst().getStarttime()+", Booking Status: "+bll.getSecond()+".");
			c++;
		}
	}

	public void addbookings(String userId) {
		System.out.println("Enter City: ");
		String city=scanner.nextLine();
		int c=1;
		List<GymCenter> gc=gymOwnerService.getCityGymcenters().get(city);
		for(GymCenter gcc :gc){
			System.out.println(c + ". " + gcc.getGymName());
			c++;
		}
		System.out.println("Enter Gym Name: ");
		String gn=scanner.nextLine();
		if(gymOwnerService.searchcitygc(gn, city)!=null){
			System.out.println("Enter year(yyyy): ");
			int year=scanner.nextInt();
			System.out.println("Enter month(mm): ");
			int month=scanner.nextInt();
			System.out.println("Enter date(dd): ");
			int date=scanner.nextInt();
			System.out.println("Enter hour according to 24hrs clock: ");
			int hr=scanner.nextInt();
			LocalDateTime st=LocalDateTime.of(year, month, date, hr, 0, 0);
			BookingService bookingService=new BookingService();
			bookingService.bookSlot(userId, gymOwnerService.searchcitygc(gn, city), st);
		}
		else{
			System.out.println("Invalid Gym Name.");
		}
	}

	public void cancelbookings(String userId) {
		System.out.println("Enter City: ");
		String city=scanner.nextLine();
		int c=1;
		List<GymCenter> gc=gymOwnerService.getCityGymcenters().get(city);
		for(GymCenter gcc :gc){
			System.out.println(c + ". " + gcc.getGymName());
			c++;
		}
		System.out.println("Enter Gym Name: ");
		String gn=scanner.nextLine();
		if(gymOwnerService.searchcitygc(gn, city)!=null){
			System.out.println("Enter year(yyyy): ");
			int year=scanner.nextInt();
			System.out.println("Enter month(mm): ");
			int month=scanner.nextInt();
			System.out.println("Enter date(dd): ");
			int date=scanner.nextInt();
			System.out.println("Enter hour according to 24hrs clock: ");
			int hr=scanner.nextInt();
			LocalDateTime st=LocalDateTime.of(year, month, date, hr, 0, 0);
			BookingService bookingService=new BookingService();
			bookingService.cancelslotbooking(userId, gymOwnerService.searchcitygc(gn, city), st);
			System.out.println("Booking cancelled successfully.");
		}
		else{
			System.out.println("Invalid Gym Name.");
		}
	}
	public void editProfile(User user) {

		Customer customer = customers.get(user.getUserid());

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
					customer.setPhone(scanner.nextLine());
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
