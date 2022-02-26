package com.demo.HibHql;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		SessionFactory sf = configuration.buildSessionFactory();
		
		Session session = sf.openSession();
		//To insert mass data
//		Random r= new Random();
//		
//		for(int i=1;i<=50;i++) {
//			Student s=new Student();
//			s.setRollno(i);
//			s.setName("Name "+i);
//			s.setMarks(r.nextInt(100));
//			session.save(s);
//			
//		}
//		
		
		//To Fetch list of data using HQL
		
//		Query q1=session.createQuery("from Student where marks>50");
//		List<Student> student=q1.list();
//		
//		for(Student s:student) {
//			System.out.println(s);
//		}
		
		
		//Fetch only 1 record
//		Query q1=session.createQuery("from Student where marks=50");
//		Student student=(Student)q1.uniqueResult();
//		System.out.println(student);		
//		
		
		
		//with select * sql
		
//To Fetch list of data using HQL
		
		Query q1=session.createQuery("Select rollno, marks, name from Student");
		List<Object[]> student= (List<Object[]>) q1.list();
		
		for(Object[] s:student) {
			System.out.println(s[0] + ":"+ s[1]+ ":"+ s[2]);
		}
		session.beginTransaction();
		session.getTransaction().commit();
		
    }
}
