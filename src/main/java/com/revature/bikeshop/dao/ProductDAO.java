package com.revature.bikeshop.dao;
import java.util.List;

import com.revature.bikeshop.model.Product;

public interface ProductDAO {
	public List<Product> getAllProducts();
	public List<Product> getAllProductsNotInCart();
	public Product getProductById(String productId);
	public Product getProductById(int productId);
	public boolean addProduct(Product name);
	public boolean updateProduct(Product name);
	public boolean deleteProductById(String productId);
	public boolean deleteProductById(int productId);

}
