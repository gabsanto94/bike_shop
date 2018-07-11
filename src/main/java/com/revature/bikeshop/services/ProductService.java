package com.revature.bikeshop.services;

import java.util.List;

import com.revature.bikeshop.model.Product;

public interface ProductService {

	void addProduct (Product product);
	
	Product getProductById(int productId);
	
	boolean updateProduct(Product product);
	
	void removeProduct(int productId);
	
	List<Product> getAllProducts();
	
}
