package com.vti.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PlayTime")
public class PlayTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "playTimeId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playTimeId;

	@ManyToOne()
	@JoinColumn(name = "computerId", nullable = false)
	private Computer computer;

	@ManyToOne()
	@JoinColumn(name = "playerId", nullable = false)
	private Player player;

	@Column(name = "orderId")
	private int orderId;

	@Column(name = "startTime")
	private String startTime;

	@Column(name = "endTime")
	private String endTime;

	@Column(name = "pricePerHour")
	private int pricePerHour = 8000;

	@Column(name = "timeToPlay")
	private long timeToPlay;

	@Column(name = "priceTotal")
	private long priceTotal;

	public PlayTime() {
	}

	public PlayTime(Computer computer, Player player, int orderId) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.computer = computer;
		this.player = player;
		this.orderId = orderId;
		this.startTime = format.format(new Date());
		this.endTime = format.format(new Date());
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getPlayTimeId() {
		return playTimeId;
	}

	public void setPlayTimeId(int playTimeId) {
		this.playTimeId = playTimeId;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public long getTimeToPlay() {
		return timeToPlay;
	}

	public void setTimeToPlay(long timeToPlay) {
		this.timeToPlay = timeToPlay;
	}

	public long getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(long priceTotal) {
		this.priceTotal = priceTotal;
	}
}
