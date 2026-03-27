package com.mphasis.firsthibernateapp.dao;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Contact;
import com.mphasis.firsthibernateapp.util.HibernateUtil;


public class ContactDAO {

	public boolean save(Contact contact) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.persist(contact);
		session.getTransaction().commit();
		session.close();
		return true;

	}

	public Contact findById(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Contact c = session.find(Contact.class, id);
		session.getTransaction().commit();
		session.close();
		return c;

	}

	public boolean del(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Contact c = session.find(Contact.class, id);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean updateEmail(String id, String newemail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Contact c = session.find(Contact.class, id);
		c.setEmail(newemail);
		session.persist(c);
		session.getTransaction().commit();
		session.close();
		return true;
	}
}
