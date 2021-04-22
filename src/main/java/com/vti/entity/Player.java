package com.vti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Player")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "playerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false)
	private Person person;

//	@OneToMany(mappedBy = "player")
//	private Set<Orders> orders;

//	@OneToMany(mappedBy = "player")
//	private Set<PlayTime> playTime;

	@Column(name = "phoneNumber", length = 12)
	private String phoneNumber;

	@Column(name = "playHours", nullable = false)
	private int playHours;

	public Player() {
	}

	public Player(int playerId, Person person, String phoneNumber, int playHours) {
		this.playerId = playerId;
		this.person = person;
		this.phoneNumber = phoneNumber;
		this.playHours = playHours;
	}

	public Player(Person person, String phoneNumber) {
		this.person = person;
		this.phoneNumber = phoneNumber;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPlayHours() {
		return playHours;
	}

	public void setPlayHours(int playHours) {
		this.playHours = playHours;
	}

}
