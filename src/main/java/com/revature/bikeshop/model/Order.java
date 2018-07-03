package com.revature.bikeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order_Sequence")
	@SequenceGenerator(name = "order_Sequence", sequenceName = "Order_SEQ")
	private int orderId;
	
	@Column(name = "cart")
	private Cart cart;
	
	@Column(name = "user")
	private User user;
	
	@Column(name = "billAddress")
	private String billAddress;
	
	@Column(name = "shipAddress")
	private String shipAddress;
	
	
	
	public Order() {
		super();
	}
	
	public Order(int orderId, Cart cart, User user, String billAddress, String shipAddress) {
		super();
		this.orderId = orderId;
		this.cart = cart;
		this.user = user;
		this.billAddress = billAddress;
		this.shipAddress = shipAddress;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBillAddress() {
		return billAddress;
	}
	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cart=" + cart + ", billAddress=" + billAddress + ", shipAddress="
				+ shipAddress + "]";
	}

}
