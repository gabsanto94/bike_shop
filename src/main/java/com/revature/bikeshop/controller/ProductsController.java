package com.revature.bikeshop.controller;


import com.revature.bikeshop.model.Product;
import com.revature.bikeshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService ps;


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody
    Product registerUser(@RequestBody Product product) {

        System.out.println("Product: " + product);


        ps.addProduct(product);

        return product;
    }

    //all the products
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProducts(){
        System.out.println("am i get into products");

        return ps.getAllProducts();
    }

    //product by id, probobly use for the product specific pages, or adding to cart
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable int id) {
        System.out.println("getting product by id.");
        return ps.getProductById(id);
    }

    //update a product from a put request
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateProduct(@RequestBody Product product, @PathVariable int id) {

        boolean isProductUpdated = false;

        //check to see if we have the same data - not letting user give us 5 and we  have a customer 3
        if(id == product.getProductId()){
            //      ps.updateProduct(product);
            isProductUpdated = true;
        }

        if(isProductUpdated){
            return "200";
        }

        //if nothing send bad request

        return "fail";
    }

    //product delete request
    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable int id) {
        System.out.println("in delete");
        System.out.println(id);
        ps.removeProduct(id);
    }

}
