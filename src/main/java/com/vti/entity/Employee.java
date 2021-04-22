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
@Table(name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false)
	private Person userId;

	@Column(name = "fullName", length = 50)
	private String fullName;

	@Column(name = "workday")
	private int workday;

//	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
//	private Set<Orders> orders;

	public Employee(int employeeId, Person userId, String fullName, int workday) {
		this.employeeId = employeeId;
		this.userId = userId;
		this.fullName = fullName;
		this.workday = workday;
	}

	public Employee(Person userId, String fullName) {
		this.userId = userId;
		this.fullName = fullName;
	}

	public Employee() {
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Person getUserId() {
		return userId;
	}

	public void setUserId(Person userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getWorkday() {
		return workday;
	}

	public void setWorkday(int workday) {
		this.workday = workday;
	}
}