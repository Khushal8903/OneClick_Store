package com.oneclick.model;

import java.util.Date;

public class Shipment {
	private int shipment_id;
	private int order_id;
	private String shipment_status;
	private String tracking_number;
	private Date shipment_date;
	public int getShipment_id() {
		return shipment_id;
	}
	public void setShipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getShipment_status() {
		return shipment_status;
	}
	public void setShipment_status(String shipment_status) {
		this.shipment_status = shipment_status;
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public Date getShipment_date() {
		return shipment_date;
	}
	public void setShipment_date(Date shipment_date) {
		this.shipment_date = shipment_date;
	}
	
	
}
