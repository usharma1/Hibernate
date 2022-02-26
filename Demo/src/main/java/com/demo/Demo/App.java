package com.demo.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		
		Laptop laptop=new Laptop();
		laptop.setLid(101);
		laptop.setLname("Del");
		
		
		Student student=new Student();
		student.setRollno(101);
		student.setName("USha");
		student.setMarks(88);
		//student.setLaptop(laptop);
		//for list
		student.getLaptop().add(laptop);
		
		laptop.getStudent().add(student);
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(laptop);
		
		tx.commit();

		/*
		 * for finding records
		 * 
		 * System.out.println( "Hello World!" ); Hib bean=new Hib(); //bean.setId(105);
		 * //bean.setName("Usha");
		 * 
		 * Configuration configuration=new
		 * Configuration().configure().addAnnotatedClass(Hib.class); SessionFactory
		 * sf=configuration.buildSessionFactory(); Session session=sf.openSession();
		 * 
		 * Transaction tx =session.beginTransaction();
		 * 
		 * bean=session.get(Hib.class, 101);
		 * 
		 * //session.save(bean);
		 * 
		 * tx.commit();
		 * 
		 * System.out.println(bean);
		 */
	}
}
