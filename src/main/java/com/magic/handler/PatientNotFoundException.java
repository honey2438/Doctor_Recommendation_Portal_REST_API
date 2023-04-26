package com.magic.handler;

public class PatientNotFoundException extends RuntimeException {
	public PatientNotFoundException(String msg) {
		super(msg);
	}
}
