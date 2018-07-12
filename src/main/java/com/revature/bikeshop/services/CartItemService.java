package com.revature.bikeshop.services;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CartItemService {

    List<CartItem> getAllItems();

    void addCartItem(CartItem cartItem);

    void removeCartItem(int cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (int productId);

	//List<Cart> getAllCarts();

}