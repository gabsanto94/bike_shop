package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.Cart;
import com.revature.bikeshop.model.CartItem;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

        Transaction t = session.beginTransaction();

        try {
            //userId = (Integer) session.save(user);
            session.save(cartItem);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        //check if our insert worked
        boolean success = session.contains(cartItem);

        //close session
        session.close();

        return success;
    }

    @Override
    public boolean removeCartItem(int cartItemId) {
        //create a session
        Session session = HibernateUtil.getHibernateSession();

        //structure our query
        String hql = "DELETE FROM com.revature.bikeshop.model.CartItem ci WHERE ci.cartItemId = :input";

        //query
        Query query = session.createQuery(hql);
        query.setParameter("input", cartItemId);

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
        String hql_items = "DELETE FROM com.revature.bikeshop.model.Cart c WHERE c.cartId = :input";

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
	public List<CartItem> getAllItems() {
		List<CartItem> cartItem;
        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //object class
        String hql = "from com.revature.bikeshop.model.CartItem";

        //query in our session
        TypedQuery<CartItem> query = session.createQuery(hql, CartItem.class);

        //get list
        cartItem = query.getResultList();

        session.close();

        // return the list of objects populated by the DB.
        return (cartItem);
    }

    @Override
    public List<CartItem> getItemsByUserId(int userId) {

        List<CartItem> cartItem;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //construct our query
        String hql = "FROM com.revature.bikeshop.model.CartItem ci WHERE ci.cart.user.userId = :input";

        //query
        TypedQuery<CartItem> query = session.createQuery(hql, CartItem.class);
        query.setParameter("input", userId);

        //get list
        cartItem = query.getResultList();

        session.close();

        // return the list of objects populated by the DB.
        return cartItem;
    }
}
