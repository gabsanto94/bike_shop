package com.revature.bikeshop.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name = "Cart_Items")
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "cartItem_Sequence", sequenceName = "CartItem_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cartItem_Sequence")
	private int cartItemId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productId")
	private Product product;
	
	@Column
	private int quantity;
	
	@Column
	private double totalPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
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
