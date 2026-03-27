package com.mphasis.firsthibernateapp.dao;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Department;
import com.mphasis.firsthibernateapp.model.Employee;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class EmployeeDAO { 
	
        public boolean addEmployee(Employee employee) {
        	Session session =HibernateUtil.getSessionFactory().getCurrentSession();
    		session.beginTransaction();
    		session.persist(employee);
    		session.getTransaction().commit();
    		session.close();
    		System.out.println("Saved...");
        	
        	return true;
        }
        public boolean addDepartment(Department department) {
        	
        	Session session =HibernateUtil.getSessionFactory().getCurrentSession();
    		session.beginTransaction();
    		session.persist(department);
    		session.getTransaction().commit();
    		session.close();
    		System.out.println("Saved...");
        	return true;
        }
        public boolean assign(String empid,String deptid) {
        	
        	Session session =HibernateUtil.getSessionFactory().getCurrentSession();
        	session.beginTransaction();
        	Employee employee =session.find(Employee.class, empid);
        	Department department = session.find(Department.class, deptid);
        	employee.setDepartment(department);
        	session.persist(employee);
        	session.getTransaction().commit();
        	session.close();
        	return true;
        
}
}