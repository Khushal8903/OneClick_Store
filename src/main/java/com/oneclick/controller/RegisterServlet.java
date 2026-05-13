package com.oneclick.controller;

import java.io.IOException;

import com.oneclick.model.Customer;
import com.oneclick.service.UserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

    
        Customer customer = new Customer(name, email, password, contact, address);

 
        boolean result = userService.registerUser(customer);

        if (result) {
            response.sendRedirect("views/user/login.jsp");
        } else {
            response.getWriter().println("Registration Failed");
        }
    }
}