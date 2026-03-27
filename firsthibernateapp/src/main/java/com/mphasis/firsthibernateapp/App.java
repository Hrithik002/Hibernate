package com.mphasis.firsthibernateapp;

import com.mphasis.firsthibernateapp.dao.ContactDAO;
import com.mphasis.firsthibernateapp.model.Contact;



public class App {
    public static void main(String[] args) {
    	ContactDAO contactDAO = new ContactDAO();
    	Contact c = new Contact ("C1", "jai","jai@gmail.com");
    	if(contactDAO.save(c))
    		System.out.println(c.getId()+"Saved");
    }
}
  /*   //save();
  //findById("c1");
    // del("C2");
    updateEmail("C1","jaiho@gmail.com");   
    }
    public static void save() {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Contact contact = new Contact ("C2", "Veeru","veeru@gmail.com");
    			
    	//Contact contact = new Contact ("C1", "jai","jai@gmail.com");
    	session.persist(contact);
    	session.getTransaction().commit();
    	session.close();
    	System.out.println("Saved");
    	
    	
}
    public static void findById (String id) {
    	
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	
    	Contact c =session.find(Contact.class,id);
    	System.out.println(c.getId()+"," +c.getName()+"," +c.getEmail());	

    	session.persist(c);

    	session.getTransaction().commit();
    	session.close();
    	
    	System.out.println(id+"updated");
    	
    }
    
    public static void del(String id) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Contact c =session.find(Contact.class,id);	
    	session.remove(c);
    	
    	session.getTransaction().commit();
    	session.close();
    	System.out.println("deleted");
}
    
    public static void updateEmail (String id,String newemail) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Contact c =session.find(Contact.class,id);	
    	c.setEmail(newemail);
    	session.persist(c);
    	session.getTransaction().commit();
    	session.close();
    	System.out.println("updated");
}
} */
