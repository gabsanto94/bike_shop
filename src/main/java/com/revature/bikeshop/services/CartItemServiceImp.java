package com.revature.bikeshop.services;

import com.revature.bikeshop.dao.CartDAO;
import com.revature.bikeshop.dao.CartItemDAO;
import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImp implements CartItemService{

    @Autowired
    private CartItemDAO cartItemDAO;

    @Autowired
    private CartDAO cartDAO;

    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    public void removeCartItem(int cartItemId){
        cartItemDAO.removeCartItem(cartItemId);
    }


    public void removeAllCartItems(Cart cart){
        cartItemDAO.removeAllCartItems(cart);
    }

    @Override
    public List<CartItem> getCartItemsByUserId(int userId) {
        return cartItemDAO.getItemsByUserId(userId);
    }


}
