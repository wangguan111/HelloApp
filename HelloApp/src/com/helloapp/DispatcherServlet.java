package com.helloapp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//3-2
//(3-1,3-2,3-3)
//http://localhost:8080/HelloApp/login.htm


//1.doGet,doPost
//2.url
//3.initParams
//4.setAttribute,getAttribute
//5.getParameter

//@WebServlet("/dispatcher")
@WebServlet(
		description = "for the first test servlet", 
		urlPatterns = { "/dispatcher" }, 
		initParams = 
			{ 
				@WebInitParam(name = "user", value = "manager", description = "user id"),		  
				@WebInitParam(name = "password", value = "manager", description = "password") 
			}
		)
public class DispatcherServlet extends HttpServlet
{
	private static final long serialVersionUID = 3570748073146908871L;
     
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	    // If it is a get request forward to doPost()			
	    doPost(request, response);
	}
	
	private void testConfig() 
	{
		String user = getInitParameter("user");
		String password = getInitParameter("password");
	    System.out.println("user = " + user + ", password  = " + password);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		testConfig();
		
		// Get the username from the request
	    String username = request.getParameter("username");
	    // Get the password from the request
	    String password = request.getParameter("password");

	    // Add the  user to the request
	    request.setAttribute("USER", username);
	    request.setAttribute("PASSWORD", password);

	    // Forward the request to the target named
	    ServletContext context = getServletContext();

	    RequestDispatcher dispatcher = context.getRequestDispatcher("/hello.jsp");
	    dispatcher.forward(request, response);
	}

}
