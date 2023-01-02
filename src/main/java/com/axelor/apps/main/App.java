
 
package com.axelor.apps.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.axelor.apps.Emp;

public class App {
	public static void main(String[] args) {
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
         
         SessionFactory factory = meta.getSessionFactoryBuilder().build();  
         Session session = factory.openSession(); 
         System.out.println("Fetching object using get:");
         Emp s=session.get(Emp.class, 7);
         System.out.println("Id : "+s.getId());
         System.out.println("Name : "+s.getName());
         
         Emp s1=session.get(Emp.class, 7);
         s1.setName("prachi");
         session.save(s);
         
        Emp s2=session.get(Emp.class, 8);
        session.delete(s2);
 
         Transaction t = session.beginTransaction();  
		
         Emp e1 = new Emp();
         e1.setName("mahek");
         session.save(e1);  
         t.commit();   
         System.out.println("successfully saved");    
          factory.close();  
          session.close();    
          
          
	}
}