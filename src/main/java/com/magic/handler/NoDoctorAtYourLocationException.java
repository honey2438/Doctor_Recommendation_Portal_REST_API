package com.magic.handler;

public class NoDoctorAtYourLocationException extends RuntimeException {
	public NoDoctorAtYourLocationException(String msg)
	{
		super(msg);
	}
}
