package com.vti.dto;

import com.vti.entity.Person;

public class PersonCreatDTO {
	private String userName;

	private String password;

	public PersonCreatDTO() {
	}

	public PersonCreatDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
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

	public Person toEntity() {
		return new Person(userName, password);
	}

}
