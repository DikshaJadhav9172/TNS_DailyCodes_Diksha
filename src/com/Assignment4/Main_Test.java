package com.Assignment4;

public class Main_Test {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking("Concert", "Alice", 2);
        
        //Static Inputs 
        booking.makePayment(5000.0);  // Cash
        booking.makePayment("WALLET123", 4500.0);  // Wallet
        booking.makePayment("4111111111111111", "123", "Alice", 6000.0);  // Credit Card
    }
}
