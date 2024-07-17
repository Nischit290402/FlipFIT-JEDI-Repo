
package com.flipkart.business;

import com.flipkart.bean.Login;
import java.util.Scanner;

public class UserLogin {
    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for email and password
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Create a new Login object with user input
        Login login = new Login(email, password);

        // Output the email and password using the instance 'login'
        System.out.println("Email: " + login.getEmail());
        System.out.println("Password: " + login.getPassword());

        scanner.close();
        
//        handle login 
    }
    
}
