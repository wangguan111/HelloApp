package com.helloapp;

//4-8

public class Counter 
{
	private int count;
	
	Counter()
	{
		this(0);
	}
	
	Counter(int count)
	{
		this.setCount(count);
	}

	public int getCount() 
	{
		return count;
	}

	public void setCount(int count) 
	{
		this.count = count;
	}
	
	public void add()
	{
		count++;
	}
}
