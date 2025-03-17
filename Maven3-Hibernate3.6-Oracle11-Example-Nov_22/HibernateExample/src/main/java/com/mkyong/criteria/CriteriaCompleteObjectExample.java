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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class CriteriaCompleteObjectExample {
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
		System.out.println("Criteria created");
		
		//restriction the api to filter the data
		criteria.add(Restrictions.ge("grossSalary", 10000f));
		
		//order api to sort the data
		criteria.addOrder(Order.desc("grossSalary"));
		
		
		criteria.setFirstResult(5);
		criteria.setMaxResults(5);
		
		List<DBUser> users = criteria.list();
		System.out.println("users object created ");
		
		Iterator<DBUser> iterator = users.iterator();
		System.out.println("Iterator created");
		
		//Actual call	
		DBUser user = null;
		while(iterator.hasNext()) {
			
		
         user = iterator.next();  
         System.out.println(user.getUserId()+","+user.getCreatedDate()+","+user.getGrossSalary());
		} 
        
		//close the session object
		session.close();
	}
}
