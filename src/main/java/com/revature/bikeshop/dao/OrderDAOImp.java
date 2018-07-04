package com.revature.bikeshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.Session;

import com.revature.bikeshop.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDAOImp implements OrderDAO {

    @Override
    public boolean addUserOrder(Order order) {
        //create session
        Session session = HibernateUtil.getHibernateSession();

        //begin transaction
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();

        //check if our insert worked
        boolean success = session.contains(order);

        //close session
        session.close();

        return success;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //object order.class
        String hql = "from com.revature.bikeshop.model.Order";

        //query in our session
        TypedQuery<Order> query = session.createQuery(hql, Order.class);

        //get list of orders
        orders = query.getResultList();

        session.close();

        // return the list of orders objects populated by the DB.
        return orders;
    }

    @Override
    public List<Order> getAllOrdersByUsername(String user) {

        List<Order> orders;

        //get the session from manager class
        Session session = HibernateUtil.getHibernateSession();

        //object order.class
        String hql = "from com.revature.bikeshop.model.Order where 'username' =: input";

        //query in our session
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("input", user);

        //get list of orders
        orders = query.getResultList();

        session.close();

        // return the list of orders objects populated by the DB.
        return orders;
    }

}
