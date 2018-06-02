package com.helloapp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


//5-17

//@WebServlet("/cross")
@WebServlet(
		description = "for test cross seervlet", 
		urlPatterns = { "/cross" }
		)
public class CrossServlet extends GenericServlet 
{
	private static final long serialVersionUID = -4957785590686648850L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{		
//		String username = request.getParameter("username");
//		String message = null;
//		if(username == null)
//		{
//			message = "input name";
//		}
//		else
//		{
//			message = "hello " + username;
//		}
		
		ServletContext context = getServletContext();
		
		ServletContext crossContext = context.getContext("/HelloApp1");
		
		RequestDispatcher dispatchar = crossContext.getRequestDispatcher("/output");
		
		//PrintWriter out = response.getWriter();
		
		dispatchar.forward(request,response);
	}
}
