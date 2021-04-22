package com.vti.dto;


public class OrdersCreatDTO {
	private int playerId;

	private int employeeId;

	private int computerId;

	public OrdersCreatDTO() {
	}

	public OrdersCreatDTO(int playerId, int employeeId, int computerId) {
		this.playerId = playerId;
		this.employeeId = employeeId;
		this.computerId = computerId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getComputerId() {
		return computerId;
	}

	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}

}
