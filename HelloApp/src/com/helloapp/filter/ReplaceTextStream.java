package com.helloapp.filter;

import java.io.*;
import javax.servlet.*;

//20-4
//20-5,20-6

class ReplaceTextStream extends ServletOutputStream 
{
	private OutputStream intStream;
	private ByteArrayOutputStream buffStream;//buff
	private boolean closed = false;

	private String oldStr;
	private String newStr;

	public ReplaceTextStream(OutputStream outStream, String searchStr, String replaceStr)
	{
		intStream = outStream;
		buffStream = new ByteArrayOutputStream();
		oldStr = searchStr;
		newStr = replaceStr;
	}

	@Override
	public void write(int a) throws IOException 
	{
	    System.out.println("ReplaceTextStream write");
	    
		buffStream.write(a);
	}

	@Override
	public void println(String s) throws IOException
	{
	    System.out.println("ReplaceTextStream println");
	    
		s = s + "\n";
		byte[] bs = s.getBytes();
		buffStream.write(bs);
	}
	
	@Override
	public void close() throws java.io.IOException 
	{
		if (!closed) 
		{
		    System.out.println("ReplaceTextStream close");
		    
			processStream();
			intStream.close();
			closed = true;
		}
	}

	@Override
	public void flush() throws java.io.IOException
	{
		if (buffStream.size() != 0)
		{
			if (!closed) 
			{
			    System.out.println("ReplaceTextStream flush");
			    
				processStream(); // need to synchronize the flush!
				buffStream = new ByteArrayOutputStream();
			}
		}
	}

	public void processStream() throws java.io.IOException
	{
		intStream.write(replaceContent(buffStream.toByteArray()));
		intStream.flush();
	}

	public byte[] replaceContent(byte[] inBytes)
	{
		String retVal = "";
		String firstPart = "";

		String tpString = new String(inBytes);
		String srchString = (new String(inBytes)).toLowerCase();

		int endBody = srchString.indexOf(oldStr);

		if (endBody != -1) 
		{
			firstPart = tpString.substring(0, endBody);
			retVal = firstPart + newStr + tpString.substring(endBody + oldStr.length());
		} 
		else 
		{
			retVal = tpString;
		}
		return retVal.getBytes();
	}

	@Override
	public boolean isReady() 
	{
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) 
	{
		
	}
}







