package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Transactional
@Component
public class CartItemDAOImp implements CartItemDAO {

    @Override
    public boolean addCartItem(CartItem cartItem) {
        //create session
        Session session = HibernateUtil.getHibernateSession();

        session.save(cartItem);

        //check if our insert worked
        boolean success = session.contains(cartItem);

        //close session
        session.close();

        return success;
    }

    @Override
    public boolean removeCartItem(CartItem cartItem) {
        //create a session
        Session session = HibernateUtil.getHibernateSession();

        //structure our query
        String hql = "DELETE FROM com.revature.bikeshop.model.CartItem WHERE 'cartitemid' = :input";

        //query
        Query query = session.createQuery(hql);
        query.setParameter("input", cartItem.getCartItemId());

        //begin transaction
        session.beginTransaction();
        int affectedRows = query.executeUpdate();
        session.getTransaction().commit();

        session.close();

        return (affectedRows > 0);
    }

    @Override
    public boolean removeAllCartItems(Cart cart) {
        //create session
        Session session = HibernateUtil.getHibernateSession();

        cart.getCartItems().clear();

        //structure our query
        String hql_items = "DELETE FROM com.revature.bikeshop.model.CartItem WHERE 'cart_id' = :input";

        Query query_items = session.createQuery(hql_items);
        query_items.setParameter("input", cart.getCartId());

        //begin transaction
        session.beginTransaction();
        query_items.executeUpdate();
        session.getTransaction().commit();

        //close session
        session.close();

        if (cart.getCartItems().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CartItem getCartItemById(int cartItemId) {
        CartItem cartItem;

        //get session
        Session session = HibernateUtil.getHibernateSession();

        //construct our query
        String hql = "FROM com.revature.bikeshop.model.CartItem WHERE 'cartItemId' = :input";

        //query
        TypedQuery<CartItem> query = session.createQuery(hql, CartItem.class);
        query.setParameter("input", cartItemId);

        //get the result
        cartItem = query.getSingleResult();

        //close session
        session.close();

        return cartItem;
    }

}
