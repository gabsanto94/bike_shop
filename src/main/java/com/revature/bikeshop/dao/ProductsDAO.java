package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.Product;

import java.util.List;

public interface ProductsDAO {

    public List<Product> getAllProducts();
    public Product getProductById(int productId);
    public boolean addProduct(Product name);
    public boolean updateProduct(Product name);
    public void deleteProductById(int productId);

}
