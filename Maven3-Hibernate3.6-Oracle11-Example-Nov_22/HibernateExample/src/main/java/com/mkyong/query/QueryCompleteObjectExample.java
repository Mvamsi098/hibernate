package com.mkyong.query;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class QueryCompleteObjectExample {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		

		

		
		//1.Load the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		// open the session object
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select user from DBUser user");
		System.out.println("query created");
		
		List<DBUser> users = query.list();
		System.out.println("users object created ");
		
		Iterator<DBUser> iterator = users.iterator();
		System.out.println("Iterator created");
		
		//Actual call	
		DBUser user = null;
		while(iterator.hasNext()) {
			
		
         user = iterator.next();  
         System.out.println(user.getUserId()+","+user.getCreatedDate());
		} 
        
		//close the session object
		session.close();
	}
}
