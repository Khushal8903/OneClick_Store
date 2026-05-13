package com.oneclick.service;

import com.oneclick.dao.UserDAO;
import com.oneclick.model.Customer;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    // REGISTER
    public boolean registerUser(Customer user) {
        return userDAO.registerUser(user);
    }

    // LOGIN
    public Customer loginUser(String email, String password) {
        return userDAO.loginUser(email, password);
    }
}