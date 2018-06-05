package com.helloapp.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//20-6
//20-4,20-5

@WebFilter(
		filterName = "ReplaceTextFilter",
		urlPatterns = { "/note" }, 
		initParams = 
			{ 
				@WebInitParam(name = "search", value = "xxx", description = "old"),
				@WebInitParam(name = "replace", value = "yyy", description = "new") 
			}
		)
public class ReplaceTextFilter implements Filter 
{
  private FilterConfig config = null;
  private String searchStr=null;
  private String replaceStr=null;
  
  @Override
  public void init(FilterConfig config) throws ServletException 
  {
     System.out.println("ReplaceTextFilter:filter is init");
	  
	 this.config = config;
    
    searchStr=config.getInitParameter("search");
    replaceStr=config.getInitParameter("replace");
  }
  
  @Override
  public void destroy() 
  {
      System.out.println("ReplaceTextFilter destroy");
	  config = null;
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException 
  {
      System.out.println("ReplaceTextFilter doFilter");
      
	  ReplaceTextWrapper myWrappedResp = new ReplaceTextWrapper( response,searchStr, replaceStr);
        
        config.getServletContext().log("ReplaceTextFilter:before call chain.doFilter()");
        chain.doFilter(request,  myWrappedResp);
        config.getServletContext().log("ReplaceTextFilter:after call chain.doFilter()");
        
        myWrappedResp.getOutputStream().close();
  }
}
