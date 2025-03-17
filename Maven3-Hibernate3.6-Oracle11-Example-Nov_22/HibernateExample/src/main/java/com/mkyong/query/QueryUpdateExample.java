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

public class QueryUpdateExample {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		

		

		
		//1.Load the hibernate configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Build the session factory
		SessionFactory factory = configuration.buildSessionFactory();
		
		// open the session object
		Session session = factory.openSession();
		
		Query query = session.createQuery("update DBUser u set u.grossSalary=?, u.netSalary=?,version=version+1 where u.userId=?");
		System.out.println("query created");
		
		query.setParameter(1, 25000f);
		query.setParameter(2, 46000f);
		query.setParameter(3, 32768);
		
		Transaction transaction = session.beginTransaction();
		
	    int numberOfRecAffected = query.executeUpdate();
	    System.out.println(numberOfRecAffected);
        
	    transaction.commit();
		//close the session object
		session.close();
	}
}
