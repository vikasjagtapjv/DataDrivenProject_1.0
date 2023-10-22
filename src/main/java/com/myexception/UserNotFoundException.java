package com.myexception;

public class UserNotFoundException extends Exception{
	

	public UserNotFoundException()
	{
		super("User not registered with system...");
	}
	
}
