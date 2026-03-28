package com.mphasis.firsthibernateapp;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Address;
import com.mphasis.firsthibernateapp.model.User;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class AppUser {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Address address = new Address("Kharadi bypass", "Pune", "411037");
		User user = new User("U1", "Maggie", address);
		session.persist(user);
		session.getTransaction().commit();
		session.close();
		System.out.println("Saved");
	}

}
