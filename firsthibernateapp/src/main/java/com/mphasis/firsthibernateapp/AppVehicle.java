package com.mphasis.firsthibernateapp;
 
import org.hibernate.Session;
 
import com.mphasis.firsthibernateapp.model.FourWheeler;
import com.mphasis.firsthibernateapp.model.TwoWheeler;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
 
public class AppVehicle {
	
	public static void main(String args[])
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		TwoWheeler tw = new TwoWheeler();
		tw.setId("V1");
		tw.setManufacturer("Honda");
		tw.setSteeringHandleType("T-Bar");	
		session.persist(tw);
		
		
		FourWheeler fw1 = new FourWheeler();
		fw1.setId("v2");
		fw1.setManufacturer("BMW");
		fw1.setSteeringHandleType("power");
		session.persist(fw1);
		
		FourWheeler fw2 = new FourWheeler();
		fw2.setId("v3");
		fw2.setManufacturer("Audi");
		fw2.setSteeringHandleType("E-power");
		session.persist(fw2);
		session.getTransaction().commit();
		session.close();
	}
 
}
 