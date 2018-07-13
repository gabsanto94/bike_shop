package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.Cart;

import java.util.List;

public interface CartDAO {

    List<Cart> getAllCarts();
    Cart getCartById(int cartId);
    boolean addCart(Cart cart);
    boolean updateCart(Cart cart);
    boolean emptyCart(int cartId);
    double getCartGrandTotal(String cartId);
}
