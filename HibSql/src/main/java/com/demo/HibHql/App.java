package com.demo.HibHql;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		//Use SQL
//		
//		SQLQuery query=session.createSQLQuery("Select * from student");
//		//we need to add below line because we will be getting entire row
//		query.addEntity(Student.class);
//		List<Student> student =query.list();
//		
//		for(Student s:student) {
//			System.out.println(s);
//		}

		
		
		//To fetch only one form
		

		SQLQuery query=session.createSQLQuery("Select name, rollno from student where marks=50");
		//below will convert output to map format
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List student =query.list();
		
		for(Object o:student) {
			Map m=(Map)o;
			System.out.println(m.get("name")+" :"+ m.get("rollno"));
		}

		session.beginTransaction();
		session.getTransaction().commit();
		
    }
}
