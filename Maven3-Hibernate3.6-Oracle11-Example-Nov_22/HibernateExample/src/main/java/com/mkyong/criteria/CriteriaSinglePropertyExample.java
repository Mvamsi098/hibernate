package com.mkyong.criteria;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class CriteriaSinglePropertyExample {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		

		

		
		//1.Load the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		// open the session object
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(DBUser.class);
		System.out.println("query created");
		
		Projection projection = Projections.property("userId");
		
		criteria.setProjection(projection);
		
		List<Integer> users = criteria.list();
		System.out.println("users object created ");
		
		Iterator<Integer> iterator = users.iterator();
		System.out.println("Iterator created");
		
		//Actual call	
		Integer user = null;
		while(iterator.hasNext()) {
			
		
         user = iterator.next();  
         System.out.println(user);
		} 
        
		//close the session object
		session.close();
	}
}
