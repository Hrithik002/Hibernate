package com.mphasis.firsthibernateapp;
 
import org.hibernate.Session;
 
import com.mphasis.firsthibernateapp.model.Contact;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
 
public class L1CacheDemo {
	public static void main(String[] args) {
		multipleSession();
	}
   public static void singleSession() {
	   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Contact c = session.find(Contact.class,"C1");
		System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Saved...");
}  
   public static void multipleSession() {
	   
	   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	 		session.beginTransaction();
	 		
	 		Contact c = session.find(Contact.class,"C1");
	 		System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
	 		session.getTransaction().commit();
	 		session.close();
	 		System.out.println("============================================");
	 		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	 		System.out.println("=============================================");
	 		
	 		
	 		session = HibernateUtil.getSessionFactory().getCurrentSession();
	 		session.beginTransaction();
	 		c = session.find(Contact.class,"C1");
	 		System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
	 		
	 		
	 		session.getTransaction().commit();
	 		session.close();
	 		System.out.println("Saved...");
   }
}
 
 