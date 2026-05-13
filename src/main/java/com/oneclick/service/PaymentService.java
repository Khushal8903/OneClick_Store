package com.oneclick.service;

import com.oneclick.dao.PaymentDAO;
import com.oneclick.model.Payment;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();

    // SAVE PAYMENT
    public boolean savePayment(Payment payment) {
        return paymentDAO.savePayment(payment);
    }
}