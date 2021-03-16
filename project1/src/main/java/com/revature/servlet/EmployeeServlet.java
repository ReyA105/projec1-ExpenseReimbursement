package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Controller.CustomerController;
import com.revature.Controller.EmployeeController;

public class EmployeeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.sendRedirect(process(req));
		
	}
	 public static String process(HttpServletRequest req) {
		 switch(req.getRequestURI()) {
		 case "/project1/Employee/home":
			 return EmployeeController.home(req);
		 }
		 return null;
	 }
}

