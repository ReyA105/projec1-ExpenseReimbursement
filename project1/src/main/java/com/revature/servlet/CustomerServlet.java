package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Controller.CustomerController;
import com.revature.Controller.LoginController;

public class CustomerServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in doGet customer");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String URI = process(req);
		res.sendRedirect(URI);
		
	}
	 public static String process(HttpServletRequest req) {
		 switch(req.getRequestURI()) {
		 case "/project1/Customer/home":
			 return CustomerController.home(req);
		 case "/project1/Customer/newReimbursement/":
			 CustomerController.addReimbursement(req);
			 return "/project1/resources/html/customerHome.html ";
		 }
		 return null;
	 }
}
