package com.revature.bikeshop.utils;

import com.revature.bikeshop.dao.UserDAO;
import com.revature.bikeshop.dao.UserDAOImp;
import com.revature.bikeshop.model.*;
import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class FireHibernate {

    public static void main (String[] args) {

        UserDAO userDao = new UserDAOImp();

        GrantedAuthority myRole = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "admin";
            }
        };

        //log.error("test");
        System.out.println("hi i am starting to make your table lazy guy...");

        Session session = HibernateUtil.getHibernateSession();
        //org.hibernate.Transaction tx = session.beginTransaction();
        BillingAddress ba = new BillingAddress(0, "325 East Mc Dowell", "Mesa", "Arizona", "85203", null);
        ShippingAddress sa = new ShippingAddress(0, "454 East Dowell", "Mesa", "Arizona", "85203", null);
        //Cart myCart = new Cart(0, null, 0, null);
        User u = new User("gabriel", "santos", "gsantos@whoa.com",
                "gabriel", "santos", ba, sa, "admin", null);

        //myCart.setUser(u);
        ba.setUser(u);
        sa.setUser(u);

        Product p3 = new Product(0, "bike1", "manufactorer1", "category1", "description", 120.00, "status1", 43);
        Product p4 = new Product(0, "bike2", "manufactorer2", "category2", "description2", 121.00, "status2", 40);

        //(int cartItemId, Product product, int quantity, double totalPrice, Cart cart)

        Cart myCart2 = new Cart(0, null, 0, u);

        CartItem item3 = new CartItem(0, p3, 2, 0, myCart2);
        CartItem item4 = new CartItem(0, p4, 6, 0, myCart2);

        //list of items
        List<CartItem> items1 = new ArrayList<CartItem>();

        items1.add(item3);
        items1.add(item4);

        u.setCart(myCart2);
        myCart2.setCartItems(items1);

        userDao.addUser(u);

        //---=------------------=---------------=---------------

        BillingAddress ba1 = new BillingAddress(0, "289 Mc Dowell", "Phoenix", "Arizona", "85605", null);
        ShippingAddress sa1 = new ShippingAddress(0, "sada East Dowell", "Phoenix", "Arizona", "85605", null);

        User u1 = new User("theo", "theo", "theo@whoa.com",
                "theo", "theo", ba1, sa1, "customer", null);

        ba1.setUser(u1);
        sa1.setUser(u1);

        Product p = new Product(0, "bike1", "manufactorer1", "category1", "description", 120.00, "status1", 43);
        Product p2 = new Product(0, "bike2", "manufactorer2", "category2", "description2", 121.00, "status2", 40);

        //(int cartItemId, Product product, int quantity, double totalPrice, Cart cart)

        Cart myCart1 = new Cart(0, null, 0, u1);

        CartItem item1 = new CartItem(0, p, 6, 0, myCart1);
        CartItem item2 = new CartItem(0, p2, 2, 0, myCart1);

        //list of items
        List<CartItem> items = new ArrayList<CartItem>();

        items.add(item1);
        items.add(item2);

        myCart1.setCartItems(items);
        u1.setCart(myCart1);
        userDao.addUser(u1);

        //tx.commit();
        //System.out.println(u);

        session.close();
        //HibernateUtil.getHibernateSession().close();

        System.out.println("finish this");
    }

}
