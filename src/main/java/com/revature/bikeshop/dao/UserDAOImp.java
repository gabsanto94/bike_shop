package com.revature.bikeshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.revature.bikeshop.model.User;
import com.revature.bikeshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class UserDAOImp implements UserDAO{

	@Override
	public List<User> getAllUsers() {

        List<User> users;

		//get the session from manager class
		Session session = HibernateUtil.getHibernateSession();

		//object class
		String hql = "from com.revature.bikeshop.model.User";

		//query in our session
		TypedQuery<User> query = session.createQuery(hql, User.class);

		//get list of users
		users = query.getResultList();
        System.out.println(users.toString());
		session.close();

		System.out.println(users.toString());
		return users;
	}

	@Override
	public User getUser(String username, String password) {
		User user;

		//get session
		Session session = HibernateUtil.getHibernateSession();

		//construct our query
		String hql = "FROM com.revature.bikeshop.model.User WHERE 'username' = :input AND 'password' = :second";

		//query
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("input", username);
		query.setParameter("second", password);

		//get the result
		user = query.getSingleResult();

		//close session
		session.close();

		return user;
	}

	@Override
    public User getUserById(int userId){


        Session session = HibernateUtil.getHibernateSession();

		User result = session.get(User.class, userId);

        session.close();

        return result;

    }

	@Override
	public boolean addUser(User user) {

	    System.out.println("im inside in the add user dao" + user);

		//create session
		Session session = HibernateUtil.getHibernateSession();

        Transaction t = session.beginTransaction();
        Integer userId = 0;
        try {
            //userId = (Integer) session.save(user);
            session.save(user);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        boolean success = session.contains(user);

        session.close();

		return success;
				
	}

	@Override
	public boolean updateUser(User user) {
		//create a session
		Session session = HibernateUtil.getHibernateSession();

        Transaction t = session.beginTransaction();

		session.saveOrUpdate(user);

		//check if update was success
		boolean success = session.contains(user);

		if(success)
		    t.commit();
		else
		    t.rollback();

		session.close();
				
		return success;

	}

	@Override
	public boolean deleteUser(int id) {
			//create session
            Session session = HibernateUtil.getHibernateSession();

            //Structure query
            String hql = "DELETE com.revature.bikeshop.model.User WHERE 'userId' = :input";

            //query
            TypedQuery<User> query = session.createQuery(hql);
            query.setParameter("input", id);

            session.beginTransaction();
                int affectedRows = query.executeUpdate();
            session.getTransaction().commit();

            session.close();

            return (affectedRows > 0);

	}

	@Override
	public boolean containsUser(String username) {

		//create a session
		Session session = HibernateUtil.getHibernateSession();
		
		//struct our hql
		String hql = "SELECT COUNT(*) FROM com.revature.bikeshop.model.User WHERE 'username' = :input";
		
		//query
		TypedQuery<Long> query = session.createQuery(hql, Long.class);
		query.setParameter("input", username);
		
		long numOfEntries = query.getSingleResult().longValue();
		
		session.close();
		
		//check if there are entries
		return (numOfEntries > 0) ? true : false;
	}

	@Override
	public boolean containsEmail(String email) {
		//create a session
        Session session = HibernateUtil.getHibernateSession();

        //struct our hql
        String hql = "SELECT COUNT(*) FROM com.revature.bikeshop.model.User WHERE 'email' = :input";

        //query
        TypedQuery<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("input", email);

        long numOfEntries = query.getSingleResult().longValue();

        session.close();

        //check if there are entries
        if(numOfEntries > 0)
            return true;
        else
            return false;
	}

}
