package com.tns.onlineshopping.services;


import com.tns.onlineshopping.dao.UserDAO;
import com.tns.onlineshopping.entities.Admin;

import java.util.List;

public class AdminService {
    private UserDAO userDAO = new UserDAO();

    public void createAdmin(Admin admin) {
        userDAO.addAdmin(admin);
    }

    public List<Admin> getAllAdmins() {
        return userDAO.getAllAdmins();
    }
}

