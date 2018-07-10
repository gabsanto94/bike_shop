package com.revature.bikeshop.dao;

import java.util.List;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;

import com.revature.bikeshop.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImp implements ProductDAO {

    @Override
    public List<Product> getAllProducts() {
        List<Product> products;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //object class
        String hql = "from com.revature.bikeshop.model.Product";

        //query in our session
        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        //get list
        products = query.getResultList();

        session.close();

        // return the list of objects populated by the DB.
        return products;
    }

    @Override
    public List<Product> getAllProductsNotInCart() {

        List<Product> products;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //object class
        String hql = "from com.revature.bikeshop.model.Product p where p.in_cart = 'false'";

        //query in our session
        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        //get list
        products = query.getResultList();

        session.close();

        // return the list of objects populated by the DB.
        return products;
    }


    @Override
    public Product getProductById(int productId) {

        Product products = null;

        //get session
        Session session = HibernateUtil.getHibernateSession();

        //construct our query
        String hql = "FROM com.revature.bikeshop.model.Product p WHERE p.productId = :input";

        //query
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("input", productId);

        //get the result
        products = query.getSingleResult();

        //close session
        session.close();

        return products;
    }

    @Override
    public boolean addProduct(Product name) {
        //create session
        Session session = HibernateUtil.getHibernateSession();

        //begin transaction
        session.beginTransaction();
        session.save(name);
        session.getTransaction().commit();

        //check if our insert worked
        boolean success = session.contains(name);

        //close session
        session.close();

        return success;
    }


    @Override
    public boolean updateProduct(Product name) {
        //create session
        Session session = HibernateUtil.getHibernateSession();

        //begin transaction
        session.beginTransaction();
        session.update(name);
        session.getTransaction().commit();

        //check if our insert worked
        boolean success = session.contains(name);

        //close session
        session.close();

        return success;
    }

    @Override
    public boolean deleteProductById(int productId) {

        //create a session
        Session session = HibernateUtil.getHibernateSession();

        //structure our query
        String hql = "DELETE FROM com.revature.bikeshop.model.Product p WHERE p.productId = :input";

        //query
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("input", productId);

        //begin transaction
        session.beginTransaction();
        int affectedRows = query.executeUpdate();
        session.getTransaction().commit();

        session.close();

        return (affectedRows > 0);

    }

}
