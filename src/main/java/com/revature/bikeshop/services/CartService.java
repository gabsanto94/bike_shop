package com.revature.bikeshop.services;

import com.revature.bikeshop.model.Cart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    Cart getCartById (int cartId);

    List<Cart> getAllCarts();

    void updateCart(Cart cart);

}
