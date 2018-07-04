package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;

public interface CartItemDAO {

	public boolean addCartItem(CartItem cartItem);
	public boolean removeCartItem(CartItem cartItem);
	public boolean removeAllCartItems(Cart cart);
	public CartItem getCartItemById(String cartItemId);
	

}
