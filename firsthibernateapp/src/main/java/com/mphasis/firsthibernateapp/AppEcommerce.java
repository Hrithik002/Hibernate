package com.mphasis.firsthibernateapp;
 
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.mphasis.firsthibernateapp.model.*;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
 
public class AppEcommerce {
 
    public static void main(String[] args) {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
 
      
        Book book = new Book();
        book.setName("Java Programming");
        book.setPrice(new BigDecimal("29.99"));
        book.setAuthor("John Doe");
        book.setIsbn("123-456789");
        book.setNumberOfPages(500);
        book.setDescription("Core Java book");
        session.persist(book);
 
      
        Electronics laptop = new Electronics();
        laptop.setName("Gaming Laptop");
        laptop.setPrice(new BigDecimal("999.99"));
        laptop.setBrand("Dell");
        laptop.setWarrantyPeriod(24);
        laptop.setPowerConsumption(180);
        laptop.setDescription("High performance laptop");
        session.persist(laptop);
 
        
        Clothing tshirt = new Clothing();
        tshirt.setName("Cotton T-Shirt");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setDescription("Comfortable cotton t-shirt"); 
        tshirt.setSize("L");
        tshirt.setColor("Blue");
        tshirt.setMaterial("Cotton");
        session.persist(tshirt);
 
        
 
        
        session.getTransaction().commit();
		session.close();
 
        
    }
}
 