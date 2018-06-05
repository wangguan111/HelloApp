package com.helloapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//4-9
//http://localhost:8080/HelloApp/counter

//1.getAttribute,setAttribute
//2.loadOnStartup
//3.setContentType

//@WebServlet("/counter")
@WebServlet(
		description = "for test save data in Attribute", 
		urlPatterns = { "/counter" }
		)
public class CounterServlet extends HttpServlet 
{
	private static final long serialVersionUID = -574106847218383606L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext context = getServletContext();
		
		Counter count = (Counter) context.getAttribute("count");

		// one and add it to the ServletContext
		if (count == null) 
		{
			count = new Counter(0);
			context.setAttribute("count", count);
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>WebCounter</title></head>");
		out.println("<body>");	
		out.println("<p>The current COUNT is : " + count.getCount() + ".</p>");
		out.println("</body></html>");
		
		count.add();
		
		context.setAttribute("count", count);
	}

}
