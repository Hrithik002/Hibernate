package com.mphasis.firsthibernateapp;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
 
import com.mphasis.firsthibernateapp.model.BlogPost;
import com.mphasis.firsthibernateapp.model.Contact;
import com.mphasis.firsthibernateapp.model.Department;
import com.mphasis.firsthibernateapp.model.User;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
 
public class AppQuery {
	
	public static void main(String args[])
	{
		//simple();
		//param();
		//agg_count();
		//lazy();
		namedquery();
	}
 
	private static void simple() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		SelectionQuery<Contact> query =
				session.createSelectionQuery("From Contact",Contact.class);
		List<Contact>contacts = query.getResultList();
		for(Contact contact:contacts) {
			System.out.println(contact.getId()+","+contact.getName()+","+contact.getEmail());
		}
		
		session.getTransaction().commit();
		session.close();
	}
	private static void param() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		SelectionQuery<Contact> query =
				session.createSelectionQuery("From Contact c where c.id =:id",Contact.class);
		query.setParameter("id","C1");
		Contact contact = query.getSingleResult();
		System.out.println(contact.getId()+","+contact.getName()+","+contact.getEmail());
		session.getTransaction().commit();
		session.close();
	}
	private static void agg_count() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		SelectionQuery<Long> query =
				session.createSelectionQuery("SELECT count(c.id) from Contact c",Long.class);
		Long count = query.getSingleResult();
		System.out.println("count="+count);
		session.getTransaction().commit();
		session.close();
	}
	private static void lazy() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		SelectionQuery<BlogPost> query =
				session.createSelectionQuery("FROM BlogPost b where b.id=:id",BlogPost.class);
		query.setParameter("id","B1");
		BlogPost blog = query.getSingleResult();
		System.out.println(blog.getId()+","+blog.getTitle()+","+blog.getAuthor());
		System.out.println(blog.getComments());
		session.getTransaction().commit();
		session.close();
	}
	private static void namedquery() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		SelectionQuery<User> query =
				session.createNamedSelectionQuery("findAll", User.class);
	    List<User> users = query.getResultList();
	    for(User user : users) {
	    	System.out.println(user.getId()+","+user.getName()+","+user.getAddress().getCity());
	    }
		session.getTransaction().commit();
		session.close();
	}
}
 
 