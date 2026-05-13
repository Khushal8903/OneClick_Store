package com.oneclick.controller;

import java.io.IOException;

import com.oneclick.model.Payment;
import com.oneclick.service.PaymentService;

import jakarta.servlet.http.*;

public class PaymentServlet extends HttpServlet{
	
	private PaymentService paymentservice = new PaymentService();
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		int amt = Integer.parseInt(req.getParameter("amount"));
		
		Payment payment = new Payment();
		payment.setPaymentId(orderId);
		payment.setAmount(amt);
		payment.setPaymentMethod("Card");
		payment.setPaymentStatus("Success");
		payment.setTransactionId("TNX" + System.currentTimeMillis());
		
		boolean result =paymentservice.savePayment(payment);
		 if (result) {
	            res.sendRedirect("views/payment/success.jsp");
	        } else {
	            res.sendRedirect("views/payment/failed.jsp");
	        }
	    }
	
}