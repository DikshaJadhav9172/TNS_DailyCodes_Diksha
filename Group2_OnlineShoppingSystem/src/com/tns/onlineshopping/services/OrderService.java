package com.tns.onlineshopping.services;


import com.tns.onlineshopping.dao.OrderDAO;
import com.tns.onlineshopping.entities.Order;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public int placeOrder(Order order) {
        return orderDAO.placeOrder(order);
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        return orderDAO.getOrdersByCustomer(customerId);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void updateOrderStatus(int orderId, String status) {
        orderDAO.updateOrderStatus(orderId, status);
    }
}
