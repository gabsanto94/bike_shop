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

    public void removeCartItem(CartItem cartItem){
        cartItemDAO.removeCartItem(cartItem);
    }


    public void removeAllCartItems(Cart cart){
        cartItemDAO.removeAllCartItems(cart);
    }



    public CartItem getCartItemById(int cartItemID) {

        return cartItemDAO.getCartItemById(cartItemID);
    }

	@Override
	public List<CartItem> getAllItems() {
		return cartItemDAO.getAllItems();
	}

	@Override
	public void removeCartItem(int cartItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}





}
