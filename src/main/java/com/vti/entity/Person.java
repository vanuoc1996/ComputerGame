package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.Enum.RolePerson;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "userId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "userName", length = 50, nullable = false)
	private String userName;

	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "role", nullable = false)
	private RolePerson rolePerson = RolePerson.PLAYER;
	public Person() {
	}

	public Person(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public RolePerson getRolePerson() {
		return rolePerson;
	}

	public void setRolePerson(RolePerson rolePerson) {
		this.rolePerson = rolePerson;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

}
