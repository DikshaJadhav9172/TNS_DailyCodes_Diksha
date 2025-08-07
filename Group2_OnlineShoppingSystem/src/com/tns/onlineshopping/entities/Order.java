package com.tns.onlineshopping.entities;

import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> items;
    private String status;

    public Order(int orderId, Customer customer, List<ProductQuantityPair> items, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<ProductQuantityPair> getItems() { return items; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId)
          .append(", Customer: ").append(customer.getUsername())
          .append(", Status: ").append(status).append("\n");

        for (ProductQuantityPair pq : items) {
            sb.append("  Product: ").append(pq.getProduct().getName())
              .append(", Quantity: ").append(pq.getQuantity()).append("\n");
        }

        return sb.toString();
    }
}
