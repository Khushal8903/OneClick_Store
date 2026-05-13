package com.oneclick.dao;

import com.oneclick.model.Payment;
import com.oneclick.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    // SAVE PAYMENT
    public boolean savePayment(Payment payment) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO payment(order_id,transaction_id,payment_method,payment_status,amount,currency) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, payment.getOrderId());
            ps.setString(2, payment.getTransactionId());
            ps.setString(3, payment.getPaymentMethod());
            ps.setString(4, payment.getPaymentStatus());
            ps.setDouble(5, payment.getAmount());
            ps.setString(6, payment.getCurrency());

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
}