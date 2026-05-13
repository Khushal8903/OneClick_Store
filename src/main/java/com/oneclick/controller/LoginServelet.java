package com.oneclick.controller;

import com.oneclick.model.Customer;
import com.oneclick.service.UserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServelet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Customer user = userService.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("views/product/products.jsp");

        } else {
            response.getWriter().println("Invalid Login");
        }
    }
}