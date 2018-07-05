package com.revature.bikeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @SequenceGenerator(name = "cart_Sequence", sequenceName = "Cart_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_Sequence")
	private int cartId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart")
	private List<CartItem> cartItems;
	
	@Column
	private double grandTotal;

	@OneToOne
    @JoinColumn(name="userId")
	@JsonIgnore
    private User user;

	public Cart() {
		super();
	}
	
	public Cart(int cartId, List<CartItem> cartItems, double grandTotal) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.grandTotal = grandTotal;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", grandTotal=" + grandTotal + "]";
	}

}
