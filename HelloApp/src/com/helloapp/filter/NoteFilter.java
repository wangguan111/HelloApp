package com.helloapp.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;

//20-1
//(20-2)

@WebFilter(
		filterName = "NoteFilter",
		urlPatterns = { "/note" }, 
		initParams = 
			{ 
				@WebInitParam(name = "ipblock", value = "128.0", description = "block"),
				@WebInitParam(name = "blacklist", value = "xxx", description = "black") 
			}
		)
public class NoteFilter implements Filter 
{
    private FilterConfig config = null;
    private String blackList = null;
    private String ipblock = null;
    
	@Override
    public void init(FilterConfig config) throws ServletException 
    {
      System.out.println("NoteFilter: filter is init");
      
      this.config = config;
      
      blackList=config.getInitParameter("blacklist");
      ipblock = config.getInitParameter("ipblock");
    }

	@Override
    public void destroy() 
    {
        System.out.println("NoteFilter destroy");
    	config = null;
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException
	{
        System.out.println("NoteFilter doFilter");
        
		String addr = request.getRemoteAddr();
		if(addr.indexOf(ipblock) == 0)
		{
			response.setContentType("text/html;charset=GB2312");
			PrintWriter out = response.getWriter();
			out.println("<h1>sorry, server can not work for ypu </h1>");
			out.flush();
			return;
		}
				
		String username = ((HttpServletRequest) request).getParameter("username");
		if (username != null)
			username = new String(username.getBytes("ISO-8859-1"), "GB2312");

		if (username != null && username.indexOf(blackList) != -1)
		{
			response.setContentType("text/html;charset=GB2312");
			PrintWriter out = response.getWriter();
			out.println("<html><head></head><body>");
			out.println("<h1>sorry," + username + ",you can not write notes </h1>");
			out.println("</body></html>");
			out.flush();
			return;
		}

		long before = System.currentTimeMillis();
		
		config.getServletContext().log("NoteFilter:before call chain.doFilter()");
		chain.doFilter(request, response);
		config.getServletContext().log("NoteFilter:after call chain.doFilter()");
		
		long after = System.currentTimeMillis();
		String name = "";
		if (request instanceof HttpServletRequest) 
		{
			name = ((HttpServletRequest) request).getRequestURI();
		}
		config.getServletContext().log("NoteFilter:" + name + ": " + (after - before) + "ms");
	}
}
