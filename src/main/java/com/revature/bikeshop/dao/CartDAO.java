package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.Cart;

public interface CartDAO {
	
	public Cart getCartById(int cartId);
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public double getCartGrandTotal(String cartId);
}
