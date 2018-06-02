package com.helloapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//5-9
//(5-9,5-10)
//http://localhost:8080/HelloApp/check?username=Tom

//1.RequestDispatcher
//2. two getRequestDispatcher method
//3.forward
//4.setAttribute,getAttribute

//@WebServlet("/check")
@WebServlet(
		description = "for test RequestDispatcher/forward", 
		urlPatterns = { "/check" }
		)
public class CheckServlet extends GenericServlet 
{
	private static final long serialVersionUID = -6149513789994354063L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String message = null;
		if(username == null)
		{
			message = "input name";
		}
		else
		{
			message = "hello " + username;
		}
		
		request.setAttribute("msg", message);
		
		ServletContext context = getServletContext();
		
		RequestDispatcher dispatchar = context.getRequestDispatcher("/output");
		//RequestDispatcher dispatchar = request.getRequestDispatcher("output");
		
		PrintWriter out = response.getWriter();
		
		out.println("output from checkservlet before forward");		
		dispatchar.forward(request,response);
		
		out.println("output from checkservlet after forward");	
	}
}
