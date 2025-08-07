package com.tns.onlineshopping.dao;

import com.tns.onlineshopping.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private ProductDAO productDAO = new ProductDAO();
    private UserDAO userDAO = new UserDAO();

    public int placeOrder(Order order) {
        int generatedOrderId = -1;

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            // 1. Insert into orders table
            String insertOrder = "INSERT INTO orders (customer_id, status) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, order.getCustomer().getUserId());
                stmt.setString(2, order.getStatus());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedOrderId = rs.getInt(1);
                }
            }

            // 2. Insert into order_items table
            String insertItem = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertItem)) {
                for (ProductQuantityPair pq : order.getItems()) {
                    stmt.setInt(1, generatedOrderId);
                    stmt.setInt(2, pq.getProduct().getProductId());
                    stmt.setInt(3, pq.getQuantity());
                    stmt.addBatch();

                    // update product stock
                    int updatedStock = pq.getProduct().getStockQuantity() - pq.getQuantity();
                    productDAO.updateStock(pq.getProduct().getProductId(), updatedStock);
                }
                stmt.executeBatch();
            }

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedOrderId;
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String status = rs.getString("status");

                List<ProductQuantityPair> items = getOrderItems(orderId);
                Customer customer = userDAO.getCustomerById(customerId);

                orders.add(new Order(orderId, customer, items, status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int customerId = rs.getInt("customer_id");
                String status = rs.getString("status");

                List<ProductQuantityPair> items = getOrderItems(orderId);
                Customer customer = userDAO.getCustomerById(customerId);

                orders.add(new Order(orderId, customer, items, status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    private List<ProductQuantityPair> getOrderItems(int orderId) {
        List<ProductQuantityPair> items = new ArrayList<>();
        String sql = "SELECT * FROM order_items WHERE order_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                Product product = productDAO.getProductById(productId);
                items.add(new ProductQuantityPair(product, quantity));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public void updateOrderStatus(int orderId, String status) {
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
