package com.revature.bikeshop.services;

import com.revature.bikeshop.dao.ProductsDAO;
import com.revature.bikeshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDAO productDao;

    @Autowired
    private ApplicationContext context;


    @PreDestroy
    public void cleanUp() {


        System.out.println("Spring Container: " +  context.getBean(this.getClass().getName()));
        System.out.println("Spring Container is destroy! ProductService Destroy");
    }


    @Override
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
        System.out.println("we in the service");
        productDao.deleteProductById(productId);

    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("product service imple getAllProducts");
        return productDao.getAllProducts();
    }

}
