package com.revature.bikeshop.model;

public class Order {

	private int orderId;
	private Cart cart;
	private User user;
	private String billAddress;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billAddress == null) ? 0 : billAddress.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((shipAddress == null) ? 0 : shipAddress.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (billAddress == null) {
			if (other.billAddress != null)
				return false;
		} else if (!billAddress.equals(other.billAddress))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (orderId != other.orderId)
			return false;
		if (shipAddress == null) {
			if (other.shipAddress != null)
				return false;
		} else if (!shipAddress.equals(other.shipAddress))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cart=" + cart + ", billAddress=" + billAddress + ", shipAddress="
				+ shipAddress + "]";
	}
	
	
	
	
	
	
}
