package com.revature.bikeshop.utils;

import com.revature.bikeshop.dao.UserDAO;
import com.revature.bikeshop.dao.UserDAOImp;
import com.revature.bikeshop.model.*;
import org.hibernate.Session;

public class FireHibernate {

    public static void main (String[] args) {

        UserDAO userDao = new UserDAOImp();

        //log.error("test");
        System.out.println("hi i am starting to make your table lazy guy...");

        Session session = HibernateUtil.getHibernateSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        BillingAddress ba = new BillingAddress(0, "325 East Mc Dowell", "Mesa", "Arizona", "85203", null);
        ShippingAddress sa = new ShippingAddress(0, "454 East Dowell", "Mesa", "Arizona", "85203", null);
        User u = new User("gabriel", "santos", "gsantos@whoa.com",
                "gabriel", "santos", ba, sa,  "admin");

        Product prd = new Product(2, "Dyson", "Dyson", "bike", "fast", 129.89, "new", 23);

        Cart myCart = new Cart(1, null, 0, u);
        CartItem ci = new CartItem(12, prd, 1,129.89, myCart );
        //myCart.setUser(u);
        ba.setUser(u);
        sa.setUser(u);
        userDao.addUser(u);
        tx.commit();
        System.out.println(u);

        session.close();
        HibernateUtil.getHibernateSession().close();

        System.out.println("finish");
    }

}
