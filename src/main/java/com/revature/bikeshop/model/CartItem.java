package com.revature.bikeshop.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem {

	@Id
    @SequenceGenerator(name = "cartItem_Sequence", sequenceName = "CartItem_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartItem_Sequence")
	private int cartItemId;
	
	@ManyToOne
    @JoinColumn
	private Product product;
	
	@Column
	private int quantity;
	
	@Column
	private double totalPrice;
	
	@ManyToOne
    @JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;
	
	
	public CartItem() {
		super();
	}
	
	public CartItem(int cartItemId, Product product, int quantity, double totalPrice, Cart cart) {
		super();
		this.cartItemId = cartItemId;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.cart = cart;
	}

	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", product=" + product + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}

}
