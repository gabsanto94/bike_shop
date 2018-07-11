package com.revature.bikeshop.controller;

import com.revature.bikeshop.dao.CartItemDAO;
import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;
import com.revature.bikeshop.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {


    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartItemDAO cartItemDAO;


    //delete - call DAO to remove items from the database
    @RequestMapping(method = RequestMethod.DELETE)
    public  @ResponseBody void deleteCart(Cart cart){
        cartItemDAO.removeAllCartItems(cart);
    }

    //@PathVariable int id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   private @ResponseBody void removeItems(@PathVariable int id){
        cartItemService.removeCartItem(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    private List<CartItem> getCartItems(){

        return cartItemService.getAllItems();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addItems(@RequestBody CartItem ci){
        System.out.println("im here");
        cartItemService.addCartItem(ci);
        return "Added Successfully.";
    }



    //delete item from cart
    // /{id}
    //public @ResponseBody String deleteItem(@RequestBody CartItem ci){

       // cartItemService.removeCartItem(ci);
      //  return "item removed.";

}

