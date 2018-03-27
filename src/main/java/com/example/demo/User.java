package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private int userId;

	@Temporal(TemporalType.DATE)
	@Column(name = "day_birth")
	private Date dayBirth;

	@Column(name = "user_address")
	@Size(min = 7, message = "Address should at least 7 character")
	private String userAddress;

	@Column(name = "user_name")
	@Size(min = 2, message = "Name should at least 2 characters")
	private String userName;

	public User() {
	}

	public User(int userId, Date dayBirth,
			@Size(min = 7, message = "Address should at least 7 character") String userAddress,
			@Size(min = 2, message = "Name should at least 2 characters") String userName) {
		super();
		this.userId = userId;
		this.dayBirth = dayBirth;
		this.userAddress = userAddress;
		this.userName = userName;
	}

	public User(Date dayBirth, @Size(min = 7, message = "Address should at least 7 character") String userAddress,
			@Size(min = 2, message = "Name should at least 2 characters") String userName) {
		super();
		this.dayBirth = dayBirth;
		this.userAddress = userAddress;
		this.userName = userName;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDayBirth() {
		return this.dayBirth;
	}

	public void setDayBirth(Date dayBirth) {
		this.dayBirth = dayBirth;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}