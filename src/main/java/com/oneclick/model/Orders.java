package com.oneclick.model;

import java.util.Date;

public class Orders {
	private int orders_id;
	private int customer_id;
	private double total_amount;
	private String orders_Status;
	private Date order_date;
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getOrders_Status() {
		return orders_Status;
	}
	public void setOrders_Status(String orders_Status) {
		this.orders_Status = orders_Status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
}
