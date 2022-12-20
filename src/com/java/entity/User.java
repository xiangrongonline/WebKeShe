package com.java.entity;

public class User {
    private String usernumber;
    private String userpassword;

    public User() {
    }

    public User(String usernumber, String userpassword) {
        this.usernumber = usernumber;
        this.userpassword = userpassword;
    }
    
    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
