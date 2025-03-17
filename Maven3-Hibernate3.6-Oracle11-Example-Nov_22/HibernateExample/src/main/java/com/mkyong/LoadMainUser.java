package com.mkyong;

import java.util.Date;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;


import com.mkyong.user.DBUser;

public class LoadMainUser {
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
		DBUser user = null;
      try {		
         user = (DBUser) session.load(DBUser.class, 10);
         System.out.println("get 1");
         System.out.println(user.getUsername()+","+user.getCreatedDate());
      } catch(ObjectNotFoundException onfe) {
    	  
      }
      
      
      try {		
          user = (DBUser) session.load(DBUser.class, 10);
          System.out.println("get 2");
          System.out.println(user.getUsername()+","+user.getCreatedDate());
       } catch(ObjectNotFoundException onfe) {
     	  
       }
         
		//close the session object
		session.close();
	}
}
