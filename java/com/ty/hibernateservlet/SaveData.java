package com.ty.hibernateservlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/savedata")
public class SaveData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 	String name = req.getParameter("name");
	        int age = Integer.parseInt(req.getParameter("age"));
	        String gender = req.getParameter("gender");
	        int aadharnum = Integer.parseInt(req.getParameter("aadharnum"));
	        String address = req.getParameter("address");
	        
	        EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
	        EntityManager em=emf.createEntityManager();
	        EntityTransaction et=em.getTransaction();

	        Person p = new Person();
	        p.setName(name);
	        p.setAge(age);
	        p.setGender(gender);

	        Aadhar aadhar = new Aadhar();
	        aadhar.setNumber(aadharnum);
	        aadhar.setAddress(address);

	        p.setAadhar(aadhar);
	        aadhar.setPerson(p);
	        
	        et.begin();
	        em.persist(p);
	        em.persist(aadhar);
	        et.commit();
	}

}
