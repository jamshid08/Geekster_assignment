package com.Jamsheed.UserManagementSystem;

public class User {
    private Integer userId;
    private String name;
    private String userName;

    private  String phoneNumber;

    private String address;
// no usage of constructor, don't need
    public User(Integer userId, String name, String userName, String phoneNumber, String address) {
        this.userId = userId;
       this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*   @Override
    public String toString() {
        return "{" + "userId" +":" + " " +this.userId+","+
                "name"+ ":" +" "+ this.name+","+
                "userName"+ ":"+ " " + this.userName +","+
                "phoneNumber"+ ":" + " "+ this.phoneNumber + "}";

    }*/
}
