package com.demo.HibCache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *Using HQL
 */
public class App2 {
	public static void main(String[] args) {
		
		Hib hib=null;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hib.class);
		SessionFactory sf = configuration.buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		Query q1=session.createQuery("from Hib where id=101");
		q1.setCacheable(true);
		hib=(Hib) q1.uniqueResult();
		System.out.println(hib);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query q2=session2.createQuery("from Hib where id=101");
		q2.setCacheable(true);
		hib=(Hib) q2.uniqueResult();
		System.out.println(hib);
		session2.getTransaction().commit();
		session2.close();
	}
}
