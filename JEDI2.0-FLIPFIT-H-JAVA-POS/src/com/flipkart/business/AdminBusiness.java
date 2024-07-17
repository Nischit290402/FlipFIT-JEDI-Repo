package com.flipkart.business;

import com.flipkart.bean.Admin;

public class AdminBusiness {
    public void createAdmin() {
        System.out.println("Admin Business Created");
    }

    public boolean updateAdmin(Admin admin) {
        System.out.println("Admin Business Updated -- " + admin.toString());
        return true;
    }

    public boolean deleteAdmin(Admin admin) {
        System.out.println("Admin Business Deleted -- " + admin.toString());
        return true;
    }
}
