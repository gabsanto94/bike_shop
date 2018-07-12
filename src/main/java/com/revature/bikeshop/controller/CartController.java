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


    //delete - call DAO to remove items from the database
    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody void deleteCart(Cart cart){
        cartItemService.removeAllCartItems(cart);
    }

    //@PathVariable int id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public @ResponseBody void removeItems(@PathVariable int id){
        cartItemService.removeCartItem(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CartItem> getCartItems(){

        return cartItemService.getAllItems();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addItems(@RequestBody CartItem ci){
        System.out.println("im here");
        cartItemService.addCartItem(ci);
        return "Added Successfully.";
    }

}
