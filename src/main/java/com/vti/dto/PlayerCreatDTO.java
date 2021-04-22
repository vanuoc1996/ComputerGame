package com.vti.dto;

import com.vti.entity.Person;

public class PlayerCreatDTO {
	private String userName;
	private String password;
	private String phoneNumber;

	public PlayerCreatDTO() {
	}

	public PlayerCreatDTO(String userName, String password, String phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person toEntity() {
		return new Person(userName, password);
	}

}
