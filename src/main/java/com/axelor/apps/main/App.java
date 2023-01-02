package com.axelor.apps.main;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.axelor.apps.Emp;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession(); 
        Transaction t = session.beginTransaction(); 
                 

        //Emp e1 = new Emp();
        //e1.setName("test");
        //session.save(e1);
        //t.commit();//transaction is commited  
        //session.close();  
          
        //System.out.println("successfully saved"); 
        //int id = 1;
	//Emp s1 = session.get(Emp.class, new Integer(id));
		//session.delete(s1);
		//session.getTransaction().commit();
		//System.out.println("record deleted.....");
		//int id = 2;
	//Emp s1 = session.get(Emp.class,new Integer(id));
		//s1.setName("sukh");	
		//session.saveOrUpdate(s1);
	//session.getTransaction().commit();
		//System.out.println("Record updated succesfully..."); 
	  
        Query query = session.createQuery("FROM Emp");
		List<Emp> e1 = query.list();
		System.out.println("-------------Records are -------------");
		for(Emp empObj : e1)
		{
			System.out.print("\n emp Id  " + empObj.getId() + " \n empname : " + empObj.getName() + "\n");
		}
		System.out.print("");
		    
		
        
        
        
}
}