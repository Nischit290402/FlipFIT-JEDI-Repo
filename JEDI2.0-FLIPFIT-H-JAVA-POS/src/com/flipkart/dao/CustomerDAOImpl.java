package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.utils.dbutils;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAOImpl implements CustomerDAO {
//    private static Map<String, List<Slot>> gymSlots = new HashMap<>();
//    private static List<Booking> bookings = new ArrayList<>();
//
//    static {
//        // Initialize with some sample data
//        Slot slot1 = new Slot("S1", LocalDateTime.of(2024, 7, 19, 8, 0), LocalDateTime.of(2024, 7, 19, 10, 0), 10);
//        Slot slot2 = new Slot("S2", LocalDateTime.of(2024, 7, 19, 10, 0), LocalDateTime.of(2024, 7, 19, 12, 0), 10);
//        gymSlots.put("G1", new ArrayList<>(List.of(slot1, slot2)));
//    }
//    public void fetchBookedSlots(String userId) {
//        for (Booking booking : bookings) {
//            if (booking.getUserID().equals(userId)) {
//                System.out.println("Booking ID: " + booking.getBookingID() + ", Gym ID: " + booking.getGymID() + ", Slot ID: " + booking.getSlotID());
//            }
//        }
//    }
//    public void cancelBooking(String GymId ,String slotId, String userId, String date){
//        Booking bookingToCancel = null;
//        LocalDate cancellationDate = LocalDate.parse(date);
//
//        for (Booking booking : bookings) {
//            if (booking.getGymID().equals(GymId) && booking.getSlotID().equals(slotId) && booking.getUserID().equals(userId) && booking.getDate().toLocalDate().equals(cancellationDate)) {
//                bookingToCancel = booking;
//                break;
//            }
//        }
//
//        if (bookingToCancel == null) {
//            System.out.println("Booking not found!");
//            return;
//        }
//
//        List<Slot> slots = gymSlots.get(bookingToCancel.getGymID());
//        if (slots != null) {
//            for (Slot slot : slots) {
//                if (slot.getSlotID().equals(bookingToCancel.getSlotID())) {
//                    slot.increaseCapacity();
//                    break;
//                }
//            }
//        }
//
//        bookings.remove(bookingToCancel);
//        System.out.println("Booking canceled successfully!");
//    }
//
//    public void addBooking(Booking booking) {
//        bookings.add(booking);
//    }
    public Customer getCustomer(User user) {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE username = ?";
        List<Booking> bookings = null;
        try (Connection connection = dbutils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String userid = resultSet.getString("userid");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String contactNo = resultSet.getString("contactNo");
                    int age = resultSet.getInt("age");

                    customer = new Customer(username, name, email, contactNo, age, user.getPassword(), userid, user.getRoleId(), bookings);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

}
