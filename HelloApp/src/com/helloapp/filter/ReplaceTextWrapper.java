package com.helloapp.filter;

import javax.servlet.http.*;
import javax.servlet.*;

//20-5
//20-4,20-6

class ReplaceTextWrapper extends HttpServletResponseWrapper 
{
	private ReplaceTextStream tpStream;

	public ReplaceTextWrapper(ServletResponse inResp, String searchText, String replaceText)throws java.io.IOException 
	{
		super((HttpServletResponse) inResp);
		
		tpStream = new ReplaceTextStream(inResp.getOutputStream(), searchText, replaceText);
	}

	public ServletOutputStream getOutputStream() throws java.io.IOException 
	{
		return tpStream;
	}
}


