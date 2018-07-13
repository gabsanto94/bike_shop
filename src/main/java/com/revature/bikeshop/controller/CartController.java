package com.revature.bikeshop.controller;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;
import com.revature.bikeshop.services.CartItemService;
import com.revature.bikeshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value="/empty/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCart(@PathVariable("id") int cartId){

        cartService.emptyCart(cartId);
    }

    //@PathVariable int id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public @ResponseBody void removeItems(@PathVariable int id){
        cartItemService.removeCartItem(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<CartItem> getCartItems(@PathVariable int id){

        return cartItemService.getCartItemsByUserId(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String addItems( @PathVariable("id") int userId, @RequestBody CartItem ci){


        Cart myCart = new Cart();
        myCart.setCartId(userId);
        ci.setCart(myCart);

        cartItemService.addCartItem(ci);
        return "Added Successfully.";
    }
}

