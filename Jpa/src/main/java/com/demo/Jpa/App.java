package com.demo.Jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//To save
    	
    	Usha usha2=new Usha();
    	usha2.setRollno(555);
    	usha2.setName("Preeti");
    	usha2.setMarks(100);
    	
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
    	EntityManager em=emf.createEntityManager();
    	
    	//to find
    	//Usha usha= em.find(Usha.class, 101);
    	//System.out.println(usha);
    	
    	//To save 	
    	em.getTransaction().begin();
    	em.persist(usha2);
    	
    	em.getTransaction().commit();
    	System.out.println(usha2);
    }
}
