package com.mkyong;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class HibernateObjectStateExamples {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		

		

		
		//1.Load the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		// open the session object
		Session session = factory.openSession();
		
		
		//Actual call	
		//Transient State
		DBUser user = null;
		
		//Persistent
         user = (DBUser) session.load(DBUser.class, 7);
         
         user.setUsername("vamsi");
         
         Transaction transaction = session.beginTransaction();
    
         transaction.commit();
         
		//close the session object
		session.close();
	}
}
