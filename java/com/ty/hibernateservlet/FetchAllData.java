package com.ty.hibernateservlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getAllData")
public class FetchAllData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select p from Person p");
		List<Person> personList = q.getResultList(); 
		
		req.setAttribute("personList", personList);  
		RequestDispatcher rd = req.getRequestDispatcher("displayAllDetails.jsp");
		rd.forward(req, resp);
	}

}
