package com.oneclick.dao;

import com.oneclick.model.Customer;
import com.oneclick.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // REGISTER USER
    public boolean registerUser(Customer user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO customer(name,email,password,contact,address) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassward());
            ps.setString(4, user.getContact());
            ps.setString(5, user.getAddress());

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

    // LOGIN USER
    public Customer loginUser(String email, String password) {

        Customer user = null;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM customer WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new Customer();

                user.setCustomerId(rs.getInt("customer_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setContact(rs.getString("contact"));
                user.setAddress(rs.getString("address"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}