package com.flipkart.client;
import com.flipkart.business.ForgotPasswordService;

import java.util.*;

public class ForgotPasswordMenu {
    private Scanner scanner;
    private ForgotPasswordService forgotPasswordService;
    public ForgotPasswordMenu(Scanner scanner){
        this.scanner=scanner;
        this.forgotPasswordService=new ForgotPasswordService();
    }

    public void forgotpassword(Scanner scanner) {
        System.out.println("Enter username: ");
        String username=scanner.nextLine();
        if(forgotPasswordService.isUser(username)){
            System.out.println("Enter new password: ");
            String newPass=scanner.nextLine();
            forgotPasswordService.resetPass(username,newPass);
            System.out.println("Password changed successfully.");
        }
        else{
            System.out.println("Username is not found.");
        }
    }
}
