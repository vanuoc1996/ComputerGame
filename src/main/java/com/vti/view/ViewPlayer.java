package com.vti.view;

import org.springframework.stereotype.Component;

import com.vti.Enum.RolePerson;
@Component
public class ViewPlayer {
	private String userName;
	private String passWord;
	private RolePerson rolePerson = RolePerson.PLAYER;
	private String phoneNumber;
	private int playHours;

	public ViewPlayer() {
	}

	public ViewPlayer(String userName, String passWord, RolePerson rolePerson, String phoneNumber, int playHours) {
		this.userName = userName;
		this.passWord = passWord;
		this.rolePerson = rolePerson;
		this.phoneNumber = phoneNumber;
		this.playHours = playHours;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public RolePerson getRolePerson() {
		return rolePerson;
	}

	public void setRolePerson(RolePerson rolePerson) {
		this.rolePerson = rolePerson;
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