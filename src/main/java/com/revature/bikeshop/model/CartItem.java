package com.revature.bikeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CartItem_Sequence")
	@SequenceGenerator(name = "cartItem_Sequence", sequenceName = "CartItem_SEQ")
	private int cartItemId;
	
	@Column(name = "product")
	private Product product;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="totalPrice")
	private double totalPrice;
	
	@OneToOne
    @JoinColumn(name = "cartId", nullable = false)
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
