package com.vti.dto;


public class LineItemCreatDTO {
	private int orderId;

	public LineItemCreatDTO() {
	}

	public LineItemCreatDTO(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
