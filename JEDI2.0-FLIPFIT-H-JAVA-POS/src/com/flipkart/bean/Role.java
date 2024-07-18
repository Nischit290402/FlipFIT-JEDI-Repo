package com.flipkart.bean;

public class Role {
    private String roleID;
    private String roleType;

    public Role(String roleID, String roleType) {
        this.roleID = roleID;
        this.roleType = roleType;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
