package com.magic.handler;

public class DoctorNotFoundException extends RuntimeException 
{
	public DoctorNotFoundException(String msg)
	{
		super(msg);
	}
}
