package com.tns.onlineshopping.application;


import com.tns.onlineshopping.entities.*;
import com.tns.onlineshopping.services.*;

import java.util.*;

public class OnlineShopping {
    private static final Scanner scanner = new Scanner(System.in);

    private static final AdminService adminService = new AdminService();
    private static final CustomerService customerService = new CustomerService();
    private static final ProductService productService = new ProductService();
    private static final OrderService orderService = new OrderService();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextInt()) {
                case 1 -> adminMenu();
                case 2 -> customerMenu();
                case 3 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void adminMenu() {
        boolean adminLoop = true;

        while (adminLoop) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");

            System.out.print("Choose an option: ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = scanner.nextInt();

                    Product product = new Product(id, name, price, stock);
                    productService.addProduct(product);
                    System.out.println("Product added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Product ID to remove: ");
                    int id = scanner.nextInt();
                    productService.removeProduct(id);
                    System.out.println("Product removed.");
                }
                case 3 -> {
                    System.out.println("Products:");
                    for (Product p : productService.getAllProducts()) {
                        System.out.println(p);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Admin ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Username: ");
                    String username = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();

                    Admin admin = new Admin(id, username, email);
                    adminService.createAdmin(admin);
                    System.out.println("Admin created.");
                }
                case 5 -> {
                    System.out.println("Admins:");
                    for (Admin a : adminService.getAllAdmins()) {
                        System.out.println(a);
                    }
                }
                case 6 -> {
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
                    String status = scanner.next();
                    orderService.updateOrderStatus(orderId, status);
                    System.out.println("Order updated.");
                }
                case 7 -> {
                    System.out.println("Orders:");
                    for (Order order : orderService.getAllOrders()) {
                        System.out.println(order);
                    }
                }
                case 8 -> adminLoop = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void customerMenu() {
        boolean customerLoop = true;

        while (customerLoop) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Return");

            System.out.print("Choose an option: ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Username: ");
                    String username = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Address: ");
                    String address = scanner.next();

                    Customer customer = new Customer(id, username, email, address);
                    customerService.createCustomer(customer);
                    System.out.println("Customer created successfully!");
                }
                case 2 -> {
                    System.out.println("Customers:");
                    for (Customer c : customerService.getAllCustomers()) {
                        System.out.println(c);
                    }
                }
                case 3 -> {
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = customerService.getCustomerById(customerId);

                    if (customer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    List<ProductQuantityPair> items = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter Product ID to add to order (or -1 to complete): ");
                        int productId = scanner.nextInt();
                        if (productId == -1) break;

                        Product product = productService.getProductById(productId);
                        if (product == null) {
                            System.out.println("Product not found.");
                            continue;
                        }

                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();

                        if (qty > product.getStockQuantity()) {
                            System.out.println("Insufficient stock.");
                        } else {
                            items.add(new ProductQuantityPair(product, qty));
                        }
                    }

                    if (!items.isEmpty()) {
                        Order order = new Order(0, customer, items, "Pending");
                        int orderId = orderService.placeOrder(order);
                        System.out.println("Order placed! ID: " + orderId);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Customer ID

