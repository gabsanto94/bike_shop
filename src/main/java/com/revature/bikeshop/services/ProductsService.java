package com.revature.bikeshop.services;

import com.revature.bikeshop.model.Product;

import java.util.List;

public interface ProductsService {

    void addProduct (Product product);

    Product getProductById(int productId);

    boolean updateProduct(Product product);

    void removeProduct(int productId);

    List<Product> getAllProducts();

}
