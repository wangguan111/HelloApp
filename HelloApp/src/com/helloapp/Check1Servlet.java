package com.helloapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//5-15
//http://localhost:8080/HelloApp/check1

//1.sendRedirect
//2.setAttribute,getAttribute is invalid
//3.getParameter is still valid

//@WebServlet("/check1")
@WebServlet(
		description = "for test sendRedirect", 
		urlPatterns = { "/check1" }
		)
public class Check1Servlet extends HttpServlet 
{
	private static final long serialVersionUID = -3620241263473881283L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
			
		PrintWriter out = response.getWriter();
		
		out.println("output from checkservlet before forward");		
		
		response.sendRedirect("/HelloApp/output1?msg="+message);	
		
		out.println("output from checkservlet after forward");	
	}
}
