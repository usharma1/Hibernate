package com.demo.HibCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//For 1st level 
		
		/*
		 * Cache Hib hib=null; Configuration configuration = new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hib.class);
		 * SessionFactory sf = configuration.buildSessionFactory(); Session session =
		 * sf.openSession(); session.beginTransaction();
		 * 
		 * 
		 * hib=session.get(Hib.class, 101); System.out.println(hib);
		 * 
		 * hib=session.get(Hib.class, 101); System.out.println(hib);
		 * 
		 * session.getTransaction().commit(); session.close();
		 */

		
		
		//2nd level Cache
		Hib hib = null;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hib.class);
		SessionFactory sf = configuration.buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();

		hib = session.get(Hib.class, 101);
		System.out.println(hib);
		session.close();

		Session session1 = sf.openSession();
		session1.beginTransaction();
		hib=session1.get(Hib.class, 101);
		System.out.println(hib);
		
		session1.getTransaction().commit();
		session1.close();
	}
}
