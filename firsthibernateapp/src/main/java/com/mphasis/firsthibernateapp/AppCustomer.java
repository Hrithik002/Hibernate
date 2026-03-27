package com.mphasis.firsthibernateapp;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Address;
import com.mphasis.firsthibernateapp.model.Customer;
import com.mphasis.firsthibernateapp.model.Locker;
import com.mphasis.firsthibernateapp.model.User;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class AppCustomer {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		Locker locker  = new Locker("L1", "TRack_A", "Big");
		session.persist(locker);
		Customer customer  = new Customer("C1", "Shrek");
		customer.setLocker(locker);
		session.persist(customer);
		session.getTransaction().commit();
		session.close();
		System.out.println("Saved");
	}

}
