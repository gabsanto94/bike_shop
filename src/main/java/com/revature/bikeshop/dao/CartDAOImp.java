package com.revature.bikeshop.dao;

import java.util.List;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
@Component
public class CartDAOImp implements CartDAO {

    @Override
    public List<Cart> getAllCarts() {
        List<Cart> carts;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //object class
        String hql = "from com.revature.bikeshop.model.Cart";

        //query in our session
        TypedQuery<Cart> query = session.createQuery(hql, Cart.class);

        //get list
        carts = query.getResultList();

        session.close();

        // return the list of objects populated by the DB.
        return carts;
    }

    @Override
    public Cart getCartById(int cartId) {
        Cart cart;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        cart = session.get(Cart.class, cartId);

        session.close();

        // return the list of items populated by the DB.
        return cart;
    }

    @Override
    public boolean addCart(Cart cart) {
        //create session
        Session session = HibernateUtil.getHibernateSession();

        Transaction t = session.beginTransaction();

        try {
            //userId = (Integer) session.save(user);
            session.save(cart);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        //check if our insert worked
        boolean success = session.contains(cart);

        //close session
        session.close();

        return success;

    }

    @Override
    public boolean updateCart(Cart cart) {
        //create a session
        Session session = HibernateUtil.getHibernateSession();

        session.saveOrUpdate(cart);

        //check if update was success
        boolean success = session.contains(cart);

        session.close();

        return success;
    }

    @Override
    public double getCartGrandTotal(String cartId) {
        double grandTotal = 0;

        Cart cart = getCartById(Integer.parseInt(cartId));
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }


}