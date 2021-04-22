package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.Enum.ComputerStatus;
@Entity
@Table(name = "Computer")
public class Computer implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "computerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int computerId;

	@Column(name = "computerName", length = 50)
	private String computerName;

	@Column(name = "computerStatus", nullable = false)
	private ComputerStatus computerStatus = ComputerStatus.OFFLINE;

	public Computer() {
	}

	public Computer(int computerId, String computerName, ComputerStatus computerStatus) {
		this.computerId = computerId;
		this.computerName = computerName;
		this.computerStatus = computerStatus;
	}

	public int getComputerId() {
		return computerId;
	}

	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public ComputerStatus getComputerStatus() {
		return computerStatus;
	}

	public void setComputerStatus(ComputerStatus computerStatus) {
		this.computerStatus = computerStatus;
	}

}
