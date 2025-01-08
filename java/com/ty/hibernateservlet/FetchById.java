package com.ty.hibernateservlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FetchById")
public class FetchById extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int personId = Integer.parseInt(req.getParameter("personId"));

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
        EntityManager em=emf.createEntityManager();
        
   
        Person person = em.find(Person.class, personId);

      
        req.setAttribute("person", person);
        RequestDispatcher rd=req.getRequestDispatcher("displayPersonDetails.jsp");
        rd.forward(req, resp);
	}

}
