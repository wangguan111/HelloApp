package com.helloapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//5-14

//@WebServlet("/greet")
@WebServlet(
		description = "for test RequestDispatcher/include", 
		urlPatterns = { "/greet" }
		)
public class GreetServlet extends HttpServlet
{
	private static final long serialVersionUID = -5984674874311289217L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("hi, " + request.getParameter("username") + "<p>");
	}
}
