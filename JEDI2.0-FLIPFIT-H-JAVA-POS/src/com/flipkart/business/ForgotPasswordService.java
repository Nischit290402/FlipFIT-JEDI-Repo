package com.flipkart.business;
import java.util.*;

import static com.flipkart.business.UserServiceInterface.UsersMap;

public class ForgotPasswordService {
    public static boolean isUser(String username){
        return UsersMap.get(username) != null;
    }
    public static void resetPass(String username, String newPass){
        UsersMap.get(username).setPassword(newPass);
    }
}
