package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Controller.LoginController;



public class LoginServlet  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		if(req.getRequestURI().equals("/project1/login"))
			req.getRequestDispatcher(LoginController.login(req)).forward(req, res);
		else if(req.getRequestURI().equals("/project1/logout")) {
				req.getSession().invalidate();
				res.sendRedirect("resources/html/login.html");
		}
	}
	
}
 