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

public class QueryMulitplePropertiesExample {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		

		

		
		//1.Load the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		// open the session object
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select user.userId,user.username from DBUser user");
		System.out.println("query created");
		
		List<Object[]> users = query.list();
		System.out.println("users object created ");
		
		Iterator<Object[]> iterator = users.iterator();
		System.out.println("Iterator created");
		
		//Actual call	
		Object[] userArr = null;
		while(iterator.hasNext()) {
			
		
         userArr = iterator.next();  
         System.out.println(userArr[0]+","+userArr[1]);
		} 
        
		//close the session object
		session.close();
	}
}
