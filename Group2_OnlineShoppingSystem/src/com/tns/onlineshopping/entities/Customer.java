package com.tns.onlineshopping.entities;

public class Customer extends User {
    private String address;

    public Customer() {}

    public Customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Customer [userId=" + userId + ", username=" + username + ", email=" + email + ", address=" + address + "]";
    }
}
