package com.flipkart.business;

public interface ForgotPasswordServiceInterface {
    public boolean isUser(String username);
    public void resetPass(String username, String newPass);
}
