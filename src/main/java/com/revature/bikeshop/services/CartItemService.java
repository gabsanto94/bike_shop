package com.revature.bikeshop.services;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;

import java.util.List;

public interface CartItemService {

    List<CartItem> getCartItemsByUserId(int userId);

    void addCartItem(CartItem cartItem);

    void removeCartItem(int cartItemId);

    void removeAllCartItems(Cart cart);


}