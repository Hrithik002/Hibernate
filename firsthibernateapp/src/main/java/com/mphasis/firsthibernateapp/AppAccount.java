package com.mphasis.firsthibernateapp;
 
import org.hibernate.Session;
 
import com.mphasis.firsthibernateapp.model.CreditAccount;
import com.mphasis.firsthibernateapp.model.DebitAccount;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
 
public class AppAccount {
 
	public static void main(String args[])
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		CreditAccount ca = new CreditAccount();
		ca.setId("c1");
		ca.setCreditlimit(100000);
		ca.setBalance(500000);
		session.persist(ca);
		
		DebitAccount da = new DebitAccount();
		da.setId("d1");
		da.setOverdraftfee(10000);
		da.setBalance(50000);
		session.persist(da);
		
		session.getTransaction().commit();
		session.close();
	}
 
}
 