package com.axelor.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");//setting the content type  
        PrintWriter pw=response.getWriter();//get the stream to write the data  
        pw.write("aneri");
        pw.println("<html><body align='center'>");
        pw.println("<h1>Register Form</h1>");
        pw.print("<form action='' method='post'>");
        pw.print("<input type='text' name='name' placeholder='Enter Name'> &nbsp;");
       
        pw.print("<input type='submit' name='submit'>");
        pw.print("</form>");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        
        Transaction t = session.beginTransaction();  
        Query query = (Query) session.createQuery("FROM emp");
        List<Emp> std = ((org.hibernate.query.Query) query).list();
        
        pw.println("<h1>");
        pw.print("<table align='center' border >");
        pw.print("<thead>");
        pw.print("<th>Id</th>");
        pw.print("<th> Name</th>");
        
        pw.print("<th>Operation</th>");
        pw.print("</thead>");
        
        
        pw.print("<tbody>");
        //
        for (Emp stuObj : std) {
        pw.print("<tr>");
        pw.print("<td>" + stuObj.getId()+ "</td>");
        pw.print("<td>" + stuObj.getName() + "</td>");
        
        pw.print("<td><a>Delete</a></td>");
        pw.print("</tr>");
        }
        pw.print("</tbody>");
        
        pw.print("<table>");
        pw.println("</h1>");
        pw.print("</html></body>");
        
      Emp s=session.get(Emp.class, 7);
        System.out.println("Id : "+s.getId());
        System.out.println("Name : "+s.getName());
        
        Emp s1=session.get(Emp.class, 7);
        s1.setName("prachi");
        session.save(s);
        
       Emp s2=session.get(Emp.class, 8);
        session.delete(s2);
	
        
         if(request.getParameter("submit")!=null)
            {
                String name = request.getParameter("name");
                
                 Emp s3= new Emp();
                 s.setName(name);
                
                 session.save(s);
                 t.commit();
                 session.close();
                 pw.print("SuccessFully Saved");
               
            
        
        
    }
	}

	
        	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
