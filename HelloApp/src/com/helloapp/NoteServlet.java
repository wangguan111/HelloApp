package com.helloapp;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


//20-2
//(20-1)

//http://127.0.0.1:8080/HelloApp/note

//@WebServlet("/note")
@WebServlet(
		description = "for test filter", 
		urlPatterns = { "/note" }
		)
public class NoteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 4282222892810274271L;
	private static final String CONTENT_TYPE = "text/html; charset=GB2312";
	
	@Override
	public void init()
	{
	    System.out.println("NoteServlet init");
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType(CONTENT_TYPE);
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>notes</title></head>");
		out.println("<body>");

		String username = request.getParameter("username");
		String content = request.getParameter("content");

		if (username != null)
			username = new String(username.getBytes("ISO-8859-1"), "GB2312");

		if (content != null)
			content = new String(content.getBytes("ISO-8859-1"), "GB2312");

		if (content != null && !content.equals(""))
			out.println("<p>" + username + " notes is:  " + content + "</P>");

		out.println(" <FORM  action=" + request.getContextPath() + "/note method=POST>");

		out.println("<b>name:</b>");
		out.println("<input type=text size=10 name=username ><br>");
		out.println("<b>notes:</b><br>");
		out.println("<textarea name=content rows=5 cols=20  wrap></textarea><br>");
		out.println("<BR>");
		out.println("<input type=submit  value=submit>");
		out.println("</form>");
		out.println("</body></html>");
	}

	@Override
	public void destroy() 
	{
      System.out.println("NoteServlet destroy");
	}
}
