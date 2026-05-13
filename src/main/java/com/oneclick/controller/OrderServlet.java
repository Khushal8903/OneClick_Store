package com.oneclick.controller;

import com.oneclick.model.Orders;
import com.oneclick.model.Customer;
import com.oneclick.service.OrderService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderService orderService = new OrderService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("user");

        double total = Double.parseDouble(request.getParameter("total"));

        Orders order = new Orders();
        order.setCustomerId(user.getCustomerId());
        order.setTotalAmount(total);
        order.setOrdersStatus("Pending");

        boolean result = orderService.placeOrder(order);

        if (result) {
            response.sendRedirect("views/order/orders.jsp");
        } else {
            response.getWriter().println("Order Failed");
        }
    }
}