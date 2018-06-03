package com.helloapp.struts2;

import com.opensymphony.xwork2.ActionSupport;

//23-1
//struts2

public class Login extends ActionSupport
{
	private static final long serialVersionUID = -9147019959572476934L;
	
	@Override
	public String execute() throws Exception 
	{
		if(name.matches("xxx") && password.matches("yyy"))
		{
			System.out.println("ok");
		}	
		return SUCCESS;
	}
	
	private String name;
	private String password;

	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
