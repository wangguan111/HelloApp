package com.helloapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//5-11
//(5-11,5-14)
//http://localhost:8080/HelloApp/main?username=Tom

//1.RequestDispatcher
//2.include
//3.getParameter

//@WebServlet("/main")
@WebServlet(
		description = "for test RequestDispatcher/include", 
		urlPatterns = { "/main" }
		)
public class MianServlet extends HttpServlet 
{
	private static final long serialVersionUID = 4779170299225008396L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
			
		ServletContext context = getServletContext();
		
		RequestDispatcher dispatchar = context.getRequestDispatcher("/greet");
		
		dispatchar.include(request, response);	
	}
}
