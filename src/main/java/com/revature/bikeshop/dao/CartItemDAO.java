package com.revature.bikeshop.dao;

import java.util.List;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;

public interface CartItemDAO {

	List<CartItem> getAllItems();

	List<CartItem> getItemsByUserId(int userId);

    public boolean addCartItem(CartItem cartItem);
    public boolean removeCartItem(int cartItemId);
    public boolean removeAllCartItems(Cart cart);



}
