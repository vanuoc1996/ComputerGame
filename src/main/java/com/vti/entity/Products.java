package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name = "productName", length = 50)
	private String productName;

	@Column(name = "listPrice")
	private int listPrice;

	public Products() {
	}

	public Products(int productId, String productName, int listPrice) {
		this.productId = productId;
		this.productName = productName;
		this.listPrice = listPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getListPrice() {
		return listPrice;
	}

	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}

}
