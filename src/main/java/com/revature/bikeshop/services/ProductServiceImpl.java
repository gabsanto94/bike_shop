package com.revature.bikeshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bikeshop.dao.ProductDAO;
import com.revature.bikeshop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDAO productDao;
	
	@Override
	//look to see what this takes in as a parameter
	//need to update these if they need a name to work, have them taking in an object of product currently
	
	public void addProduct(Product product) {
		productDao.addProduct(product);
			
	}

	@Override
	public Product getProductById(int productId) {
		return productDao.getProductById(productId);
		
	}

	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public void removeProduct(int productId) {
		productDao.deleteProductById(productId);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	
}
