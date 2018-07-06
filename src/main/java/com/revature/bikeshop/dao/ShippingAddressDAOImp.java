package com.revature.bikeshop.dao;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.bikeshop.model.ShippingAddress;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ShippingAddressDAOImp implements ShippingAddressDAO {

    @Override
    public int createShippingAddress(ShippingAddress address) {
        Session session = HibernateUtil.getHibernateSession();
        Transaction t = session.beginTransaction();
        Integer shippingAddressId = 0;
        try {
            shippingAddressId = (Integer) session.save(address);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return shippingAddressId;
    }


    @Override
    public ShippingAddress getShippingAddress(int shippingAddressId) {
        Session session = HibernateUtil.getHibernateSession();
        ShippingAddress sa = session.get(ShippingAddress.class, shippingAddressId);
        session.close();
        return sa;
    }

    @Override
    public void deleteShippingAddress(ShippingAddress address) {
        Session session = HibernateUtil.getHibernateSession();
        Transaction t = session.beginTransaction();
        session.delete(address);
        t.commit();
        session.close();
    }


    @Override
    public void updateShippingAddress(ShippingAddress address) {
        Session session = HibernateUtil.getHibernateSession();
        Transaction t = session.beginTransaction();
        session.update(address);
        t.commit();
        session.close();
    }


}
