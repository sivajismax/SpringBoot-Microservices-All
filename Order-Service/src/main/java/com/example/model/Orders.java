package com.example.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private long amount;
	private Date ordertime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String username, long amount, Date ordertime) {
		super();
		this.username = username;
		this.amount = amount;
		this.ordertime = ordertime;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", username=" + username + ", amount=" + amount + ", ordertime=" + ordertime + "]";
	}

}
