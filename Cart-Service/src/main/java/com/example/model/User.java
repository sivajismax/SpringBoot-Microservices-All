package com.example.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	private Date loginTime;

//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "passengerId")
//	private Passenger passenger;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public User(int id, String userName, String password, Date loginTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.loginTime = loginTime;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
