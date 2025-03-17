package com.mkyong;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class SaveMainUser {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		

		DBUser user = new DBUser();
		user.setUsername("steve aoki");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());
		
		//1.Load the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		// open the session object
		Session session = factory.openSession();
		
		//Begin the transcation
		Transaction  transaction =session.beginTransaction();
		
		//Actual call		
        session.persist(user);
        
        //commit the transcation
		transaction.commit();
		
		//close the session object
		session.close();
	}
}
