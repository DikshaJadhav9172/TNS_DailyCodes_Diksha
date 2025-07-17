package com.Assignment4;

public class TicketBooking {
    
    private String stageEvent;
    private String customer;
    private int noOfSeats;
    
    //parameterized Constructor 
    public TicketBooking(String stageEvent, String customer, int noOfSeats) {
        this.stageEvent = stageEvent;
        this.customer = customer;
        this.noOfSeats = noOfSeats;
    }

    // Getters and Setters methods 
    public String getStageEvent() {
        return stageEvent;
    }

    public void setStageEvent(String stageEvent) {
        this.stageEvent = stageEvent;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    // Overloaded makePayment methods
    public void makePayment(Double amount) {
        System.out.println("Amount " + amount + " paid in cash");
    }

    public void makePayment(String walletNumber, Double amount) {
        System.out.println("Amount " + amount + " paid using wallet number " + walletNumber);
    }

    public void makePayment(String creditCard, String ccv, String name, Double amount) {
        System.out.println("Holder Name: " + name);
        System.out.println("Amount " + amount + " paid using " + creditCard);
        System.out.println("CCV: " + ccv);
    }
}
