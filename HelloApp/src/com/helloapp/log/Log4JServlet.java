package com.helloapp.log;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

//31-2

//this is annotation for 31, Servlet need to be set in web.xml
////@WebServlet("/log4j")
//@WebServlet(
//		name = "log4j",
//		description = "for the log servlet", 
//		initParams = 
//			{ 
//				@WebInitParam(name = "propfile", value = "//WEB-INF//log4j.properties", description = "properties config setting")
//			},
//		loadOnStartup = 1
//		)
public class Log4JServlet extends HttpServlet
{
	private static final long serialVersionUID = 2561245202140020751L;

	@Override
	public void init() throws ServletException 
	{
		System.out.println("Log4JServlet: log sevlet is init");
		
		// Get Fully Qualified Path to Properties File
		String path = getServletContext().getRealPath("/");
		String propfile = path + getInitParameter("propfile");

		// Initialize Properties for All Servlets
		PropertyConfigurator.configure(propfile);
	}
}

