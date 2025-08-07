package com.tns.onlineshopping.services;


import com.tns.onlineshopping.dao.UserDAO;
import com.tns.onlineshopping.entities.Customer;

import java.util.List;

public class CustomerService {
    private UserDAO userDAO = new UserDAO();

    public void createCustomer(Customer customer) {
        userDAO.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return userDAO.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return userDAO.getCustomerById(id);
    }
}
