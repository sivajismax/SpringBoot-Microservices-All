package com.example.model;

public class Item {

	private int id;
	private String name;
	private double price;
	private Long itemtotal;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, double price, Long itemtotal) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemtotal = itemtotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getItemtotal() {
		return itemtotal;
	}

	public void setItemtotal(Long itemtotal) {
		this.itemtotal = itemtotal;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", itemtotal=" + itemtotal + "]";
	}

}
