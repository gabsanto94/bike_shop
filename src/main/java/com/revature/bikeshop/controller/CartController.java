package com.revature.bikeshop.controller;


import com.revature.bikeshop.dao.CartItemDAO;
import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;
import com.revature.bikeshop.services.CartItemService;
import com.revature.bikeshop.services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
    @Autowired
    private CartItemService cartItemService;

    //delete - call DAO to remove items from the database
    @RequestMapping(method = RequestMethod.DELETE)
    public  @ResponseBody void deleteCart(Cart cart){
        cartItemService.removeAllCartItems(cart);
    }

    //@PathVariable int id
    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
   private @ResponseBody void removeCartItem(@PathVariable int id){
        cartItemService.removeCartItem(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CartItem> getCartItems(){
        return cartItemService.getAllItems();
    }
    
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    @ResponseBody
    
    public String addItems(@RequestBody CartItem i) {
        System.out.println("im here");
        cartItemService.addCartItem(i);
        return "Added Successfully.";
    }



    //delete item from cart
    // /{id}
    //public @ResponseBody String deleteItem(@RequestBody CartItem ci){

       // cartItemService.removeCartItem(ci);
      //  return "item removed.";

}

