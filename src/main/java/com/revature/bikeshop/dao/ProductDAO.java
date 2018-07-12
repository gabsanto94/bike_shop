package com.revature.bikeshop.dao;
import java.util.List;

import com.revature.bikeshop.model.Product;

public interface ProductDAO {
	public List<Product> getAllProducts();
	public List<Product> getAllProductsNotInCart();
	public Product getProductById(int productId);
	public boolean addProduct(Product name);
	public boolean updateProduct(Product name);
	public void deleteProductById(int productId);

}
