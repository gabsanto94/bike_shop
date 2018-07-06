package com.revature.bikeshop.dao;

import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.bikeshop.model.BillingAddress;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class BillingAddressDAOImp implements BillingAddressDAO {

	@Override
	public int createBillingAddress(BillingAddress address) {
		Session session = HibernateUtil.getHibernateSession();
		Integer billingAddressId = 0;
		try {
			billingAddressId = (Integer) session.save(address);
		} catch ( HibernateException e ) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return billingAddressId;
	}


	@Override
	public BillingAddress getShippingAddress(int billingAddressId) {
		Session session = HibernateUtil.getHibernateSession();
		BillingAddress sa = session.get(BillingAddress.class, billingAddressId);
		session.close();
		return sa;
	}

	@Override
	public void deleteBillingAddress(BillingAddress address) {
		Session session = HibernateUtil.getHibernateSession();
		session.delete(address);
		session.close();
	}

	@Override
	public void updateBillingAddress(BillingAddress address) {
		Session session = HibernateUtil.getHibernateSession();
		session.update(address);
		session.close();
	}

}
