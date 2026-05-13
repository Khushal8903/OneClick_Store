package com.oneclick.service;

import com.oneclick.dao.OrderDAO;
import com.oneclick.model.Orders;

import java.util.List;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();

    // PLACE ORDER
    public boolean placeOrder(Orders order) {
        return orderDAO.placeOrder(order);
    }

    // GET USER ORDERS
    public List<Orders> getOrdersByCustomer(int customerId) {
        return orderDAO.getOrdersByCustomer(customerId);
    }
}