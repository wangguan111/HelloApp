package com.helloapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//4-11

//for test ServletContextListener

//1.contextInitialized
//2.contextDestroyed
//3.getResourceAsStream,getRealPath
//4.setAttribute,getAttribute

@WebListener 
public class MyServletContextListener implements ServletContextListener 
{
	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		System.out.println("Listener:app is init");

		ServletContext context = arg0.getServletContext();

		try 
		{
			InputStream in = context.getResourceAsStream("/count/count.txt");
			InputStreamReader input = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(input);
			int count = Integer.parseInt(reader.readLine());
			reader.close();
			Counter counter = new Counter(count);
			context.setAttribute("count", counter);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		System.out.println("Listener:app is destory");

		ServletContext context = arg0.getServletContext();

		Counter counter = (Counter) context.getAttribute("count");
		if (counter != null) 
		{
			String file = context.getRealPath("/count");
			file = file + "/count.txt";

			PrintWriter pw = null;

			try 
			{
				pw = new PrintWriter(file);

			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			pw.println(counter.getCount());
			pw.close();
		}
	}
}
