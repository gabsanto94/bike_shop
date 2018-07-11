package com.revature.bikeshop.services;

import com.revature.bikeshop.dao.CartDAO;
import com.revature.bikeshop.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImp implements CartService {

    @Autowired
    private CartDAO cartDAO;


    @Override
    public Cart getCartById(int cartId) {
        return cartDAO.getCartById(cartId);
    }

    @Override
    public List<Cart> getAllCarts()
    {
        return cartDAO.getAllCarts();
    }

    @Override
    public void updateCart(Cart cart){
        cartDAO.updateCart(cart);
    }
}
