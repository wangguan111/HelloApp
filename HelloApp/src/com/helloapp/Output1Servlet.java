package com.helloapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//5-16

//@WebServlet("/output1")
@WebServlet(
		description = "for test sendRedirect", 
		urlPatterns = { "/output1" }
		)
public class Output1Servlet extends HttpServlet
{
	private static final long serialVersionUID = 3283565612542127393L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String message = (String)request.getAttribute("msg");		
		System.out.println("msg in sttribute:" + message);
		
		message = request.getParameter("msg");
		System.out.println("msg in Parameter:" + message);
		
		PrintWriter out = response.getWriter();
		out.println(message);
		
		out.close();
	}
}
