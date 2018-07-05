package com.revature.bikeshop.utils;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.Session;

public class FireHibernate {

    public static void main (String[] args) {
        //log.error("test");
        System.out.println("hi i am starting to make your table lazy guy...");

        Session session = HibernateUtil.getHibernateSession();
        User u = new User("name", "santos");

        session.save(u);

        session.close();
        HibernateUtil.getHibernateSession().close();

        System.out.println("finish");
    }

}
