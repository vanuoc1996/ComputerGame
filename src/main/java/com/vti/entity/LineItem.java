package com.vti.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LineItem")
public class LineItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lineItemId")
	private int lineItemId;

	@Column(name = "orderId")
	private int orderId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId", nullable = false)
	private Products product;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private int price;

	public LineItem() {
	}

	public LineItem(int orderId) {
		this.orderId = orderId;
	}

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
