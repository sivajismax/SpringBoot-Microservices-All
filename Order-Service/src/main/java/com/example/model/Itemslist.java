package com.example.model;

//@Entity
public class Itemslist {

	// @Id
	// @GeneratedValue
	private int id;
	private String username;

	// @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name = "item_id")
	private Item item;
	private int qty;

	public Itemslist() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Itemslist(int id, String username, Item item, int qty) {
		super();
		this.id = id;
		this.username = username;
		this.item = item;
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Itemslist [id=" + id + ", username=" + username + ", item=" + item + ", qty=" + qty + "]";
	}

}
