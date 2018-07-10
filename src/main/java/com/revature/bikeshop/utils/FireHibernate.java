package com.revature.bikeshop.utils;

import org.hibernate.Session;

import com.revature.bikeshop.dao.UserDAO;
import com.revature.bikeshop.dao.UserDAOImp;
import com.revature.bikeshop.model.BillingAddress;
import com.revature.bikeshop.model.Product;
import com.revature.bikeshop.model.ShippingAddress;
import com.revature.bikeshop.model.User;

public class FireHibernate {

    public static void main (String[] args) {

        UserDAO userDao = new UserDAOImp();

        //log.error("test");
        System.out.println("hi i am starting to make your table lazy guy...");

        Session session = HibernateUtil.getHibernateSession();
        //org.hibernate.Transaction tx = session.beginTransaction();
        BillingAddress ba = new BillingAddress(0, "325 East Mc Dowell", "Mesa", "Arizona", "85203", null);
        ShippingAddress sa = new ShippingAddress(0, "454 East Dowell", "Mesa", "Arizona", "85203", null);
        //Cart myCart = new Cart(0, null, 0, null);
        User u = new User("gabriel", "santos", "gsantos@whoa.com",
                "gabriel", "santos", ba, sa,  "admin");
        //myCart.setUser(u);
        ba.setUser(u);
        sa.setUser(u);
        
        //add the product here
        Product p = new Product(0, "bike1", "manufactorer1", "category1", "description", 120.00, "status1", 43);
        Product p2 = new Product(0, "bike2", "manufactorer2", "category2", "description2", 121.00, "status2", 40);
        
       
        //tx.commit();
        System.out.println(u);

        session.close();
        HibernateUtil.getHibernateSession().close();

        System.out.println("finish");
    }

}
