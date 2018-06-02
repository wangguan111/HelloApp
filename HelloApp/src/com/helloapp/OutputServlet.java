package com.helloapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//5-10

//@WebServlet("/output")
@WebServlet(
		description = "for test RequestDispatcher/forward", 
		urlPatterns = { "/output" }
		)
public class OutputServlet extends GenericServlet {

	private static final long serialVersionUID = -1370818603645010394L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		String message = (String)request.getAttribute("msg");
		PrintWriter out = response.getWriter();
		out.println(message);
		out.close();
	}
}
