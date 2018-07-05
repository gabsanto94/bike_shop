package com.revature.bikeshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "order_Sequence", sequenceName = "Order_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_Sequence")
	private int orderId;
	
	@OneToOne
    @JoinColumn(name="cartId")
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToOne
    @JoinColumn(name = "billingAddressId")
	private BillingAddress billAddress;
	
	@OneToOne
    @JoinColumn(name = "shippingAddressId")
	private ShippingAddress shipAddress;
	
	
	
	public Order() {
		super();
	}
	
	public Order(int orderId, Cart cart, User user, BillingAddress billAddress, ShippingAddress shipAddress) {
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
	public BillingAddress getBillAddress() {
		return billAddress;
	}
	public void setBillAddress(BillingAddress billAddress) {
		this.billAddress = billAddress;
	}
	public ShippingAddress getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(ShippingAddress shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cart=" + cart + ", billAddress=" + billAddress + ", shipAddress="
				+ shipAddress + "]";
	}

}
