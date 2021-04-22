package com.vti.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.vti.Enum.OrderStatus;

@Entity
@Table(name = "Orders")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "orderId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@ManyToOne()
	@JoinColumn(name = "playerId", nullable = false)
	private Player player;

	@Column(name = "employeeId")
	private int employeeId;

	@Column(name = "createDate")
	private String createDate ;

	@Column(name = "total")
	private int total;

	@Column(name = "orderStatus")
	private OrderStatus orderStatus = OrderStatus.UNPAID;

	public Orders() {
	}

	public Orders(Player player, int employeeId) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.player = player;
		this.employeeId = employeeId;
		this.createDate = format.format(new Date());
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
