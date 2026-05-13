package com.oneclick.dao;

import com.oneclick.model.Orders;
import com.oneclick.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // PLACE ORDER
    public boolean placeOrder(Orders order) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO orders(customer_id,total_amount,status) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, order.getCustomerId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setString(3, order.getOrdersStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // GET USER ORDERS
    public List<Orders> getOrdersByCustomer(int customerId) {

        List<Orders> orderList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM orders WHERE customer_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Orders order = new Orders();

                order.setOrdersId(rs.getInt("order_id"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrdersStatus(rs.getString("status"));

                orderList.add(order);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
}