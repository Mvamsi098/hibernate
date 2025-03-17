package com.mkyong;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class GetMainUser {
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
		
         user = (DBUser) session.load(DBUser.class, 12);
         System.out.println("Get 1");
         
         if(user!= null) {
         System.out.println(user.getUsername()+","+user.getCreatedDate());
         }
         
         session.evict(user);
         user = (DBUser) session.load(DBUser.class, 12);
         System.out.println("Get 2");
         
         if(user!=null) {
         System.out.println(user.getUsername()+","+user.getCreatedDate());
         }
		//close the session object
		session.close();
	}
}
